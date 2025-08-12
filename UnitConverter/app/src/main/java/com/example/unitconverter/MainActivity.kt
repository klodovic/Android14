package com.example.unitconverter

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
    Box(
        modifier = modifier.fillMaxSize(), // Box zauzima sav prostor
        contentAlignment = Alignment.Center // Centriraj sve unutar Box-a
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Unit Converter")
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {}
            )

            Spacer(modifier = Modifier.height(10.dp))
            Row {
    //            val context  = LocalContext.current
    //            Button(onClick = {
    //                Toast.makeText(context,
    //                    "Tnx for clikcking",
    //                    Toast.LENGTH_LONG).show()
    //            })
    //            {
    //                Text("Click me")
    //            }


                //DropDown left: Button + DropDownMenu -> DropdownMenuItem
                Box {
                    Button(onClick = {}) {
                        Text("Select")
                        Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                    }
                    DropdownMenu(
                        expanded = false,
                        {}) {
                        DropdownMenuItem(text = { Text("Centimeters")}, onClick = {})
                        DropdownMenuItem(text = { Text("Meters")}, onClick = {})
                        DropdownMenuItem(text = { Text("Feet")}, onClick = {})
                        DropdownMenuItem(text = { Text("Millimeters")}, onClick = {})
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))
                //DropDown right: Button + DropDownMenu -> DropdownMenuItem
                Box {
                    Button(onClick = {}) {
                        Text("Select")
                        Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                    }
                    DropdownMenu(
                        expanded = false,
                        {}) {
                        DropdownMenuItem(text = { Text("Centimeters")}, onClick = {})
                        DropdownMenuItem(text = { Text("Meters")}, onClick = {})
                        DropdownMenuItem(text = { Text("Feet")}, onClick = {})
                        DropdownMenuItem(text = { Text("Millimeters")}, onClick = {})
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))
            Text("Result:")
        }
    }
}


@Preview
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}


