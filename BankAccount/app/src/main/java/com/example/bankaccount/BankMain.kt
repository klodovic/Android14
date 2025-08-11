package com.example.bankaccount

fun main(){

    val denisBankAccount = BankAccount("Denis Denis", 1338.20)

    denisBankAccount.deposit(200.00)
    denisBankAccount.displayTransactionHistory()
    denisBankAccount.withdraw(1200.22)
    denisBankAccount.deposit(3000.79)
    denisBankAccount.deposit(2000.50)
    denisBankAccount.withdraw(3333.15)
    denisBankAccount.displayTransactionHistory()

    println("${denisBankAccount.accountHolder} balance is ${denisBankAccount.balance}")

}