package com.example.parcial_billeteravirtual

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation () {
    val navController = rememberNavController()
    val walletViewModel: WalletViewModel = viewModel()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomePage(navController, walletViewModel)
        }
        composable("receipt/{amount}") {
                backStackEntry ->
            val amount = backStackEntry.arguments?.getString("amount")?.toDoubleOrNull() ?: 0.00
            PaymentReceiptPage(navController, amount)
        }
    }
}