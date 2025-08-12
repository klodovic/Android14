package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UnitConverter(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun UnitConverter(modifier: Modifier = Modifier) {

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Centimeters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val iConversionFactor = remember { mutableDoubleStateOf(0.01) } // npr. cm -> m
    val oConversionFactor = remember { mutableDoubleStateOf(1.0) }   // npr. m -> m

    fun convertUnits() {
        // ?: 0.0 -> elvis operator
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = inputValueDouble * iConversionFactor.doubleValue / oConversionFactor.doubleValue
        outputValue = result.toString()
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text("Unit Converter", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = inputValue,
                onValueChange = {
                    inputValue = it
                    convertUnits()
                },
                label = { Text("Enter Value") }
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row {

                // Input unit dropdown - left
                Box {
                    Button(onClick = { iExpanded = true }) {
                        Text(inputUnit)
                        Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                    }
                    DropdownMenu(
                        expanded = iExpanded,
                        onDismissRequest = { iExpanded = false }
                    ) {
                        DropdownMenuItem(text = { Text("Centimeters") }, onClick = {
                            iExpanded = false
                            inputUnit = "Centimeters"
                            iConversionFactor.doubleValue = 0.01
                            convertUnits()
                        })
                        DropdownMenuItem(text = { Text("Meters") }, onClick = {
                            iExpanded = false
                            inputUnit = "Meters"
                            iConversionFactor.doubleValue = 1.0
                            convertUnits()
                        })
                        DropdownMenuItem(text = { Text("Feet") }, onClick = {
                            iExpanded = false
                            inputUnit = "Feet"
                            iConversionFactor.doubleValue = 0.3048
                            convertUnits()
                        })
                        DropdownMenuItem(text = { Text("Millimeters") }, onClick = {
                            iExpanded = false
                            inputUnit = "Millimeters"
                            iConversionFactor.doubleValue = 0.001
                            convertUnits()
                        })
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                // Output unit dropdown - right
                Box {
                    Button(onClick = { oExpanded = true }) {
                        Text(outputUnit)
                        Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                    }
                    DropdownMenu(
                        expanded = oExpanded,
                        onDismissRequest = { oExpanded = false }
                    ) {
                        DropdownMenuItem(text = { Text("Centimeters") }, onClick = {
                            oExpanded = false
                            outputUnit = "Centimeters"
                            oConversionFactor.doubleValue = 0.01
                            convertUnits()
                        })
                        DropdownMenuItem(text = { Text("Meters") }, onClick = {
                            oExpanded = false
                            outputUnit = "Meters"
                            oConversionFactor.doubleValue = 1.0
                            convertUnits()
                        })
                        DropdownMenuItem(text = { Text("Feet") }, onClick = {
                            oExpanded = false
                            outputUnit = "Feet"
                            oConversionFactor.doubleValue = 0.3048
                            convertUnits()
                        })
                        DropdownMenuItem(text = { Text("Millimeters") }, onClick = {
                            oExpanded = false
                            outputUnit = "Millimeters"
                            oConversionFactor.doubleValue = 0.001
                            convertUnits()
                        })
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            //Result text
            Text("Result: $outputValue $outputUnit",
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}



@Preview
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}


