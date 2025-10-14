package com.example.parcial_billeteravirtual

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

class WalletViewModel : ViewModel() {
    var totalAmount by mutableDoubleStateOf(50000.00)
        private set

    fun withdraw(amount: Double) {
        if (amount <= totalAmount) {
            totalAmount -= amount
        }
    }
}
fun formatMoney(amount: Double, showDecimals: Boolean = true): String {
    val pattern = if (showDecimals) "#,##0.00" else "#,##0"
    val formatter = DecimalFormat(pattern, DecimalFormatSymbols(Locale.US))
    return formatter.format(amount)
}