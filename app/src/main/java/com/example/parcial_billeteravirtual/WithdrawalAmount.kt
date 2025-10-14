package com.example.parcial_billeteravirtual

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@SuppressLint("DefaultLocale")
@Composable
fun WithdrawalAmount (
    navController: NavController,
    walletViewModel: WalletViewModel,
    amount: Double
) {
    val options = listOf(5000.00, 10000.00, 15000.00, 20000.00)
    var input by remember { mutableStateOf(String.format("%.2f", amount)) }
    val numericValue = input.replace(",", "").toDoubleOrNull() ?: 0.00
    var isError by remember { mutableStateOf(false) }

    fun handleWithdrawal() {
        if (walletViewModel.totalAmount >= numericValue) {
            walletViewModel.withdraw(numericValue)
            navController.navigate("receipt/${numericValue}")
        } else {
            isError = true
        }
    }

    Box (
        modifier = Modifier
            .fillMaxSize()
            .padding(21.dp)
    ) {
        Column(
            modifier = Modifier.padding(top = 20.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Text("Monto a retirar")
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                options.forEach { option ->
                    SuggestionChip(
                        onClick = { input = formatMoney(option) },
                        label = { Text(formatMoney(option, showDecimals = false)) }
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(100.dp)
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp),
                    value = input,
                    onValueChange = { text ->
                        val clean = text.replace("[^\\d.]".toRegex(), "")
                        input = if (clean.isNotEmpty()) {
                            val parsed = clean.toDouble()
                            String.format("%.2f", parsed)
                        } else {
                            "0.00"
                        }
                    },
                    leadingIcon = { Text("$") },
                    label = { Text("Monto") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedTextColor = MaterialTheme.colorScheme.primary,
                    ),
                    singleLine = true,
                    isError = isError,
                    supportingText = {
                        if (isError) {
                            Text("Monto inválido")
                        }
                    }
                )
                Button(
                    modifier = Modifier
                        .width(160.dp)
                        .height(50.dp),
                    onClick = { handleWithdrawal() },
                ) {
                    Text("Retirar")
                }
            }
        }
    }
}