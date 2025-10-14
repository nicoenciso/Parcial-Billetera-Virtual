package com.example.parcial_billeteravirtual

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomePage (navController: NavController, walletViewModel: WalletViewModel) {

    Column {
        HorizontalDivider(
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.primary
        )
        AmountBadge(walletViewModel)
        WithdrawalAmount(navController, walletViewModel, amount = 0.00)
    }
}