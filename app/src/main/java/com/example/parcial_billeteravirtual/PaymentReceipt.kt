package com.example.parcial_billeteravirtual

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PaymentReceipt(navController: NavController, amount: Double) {
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Text(
                "Operación exitosa",
                fontSize = 40.sp
            )
            Icon(
                modifier = Modifier
                    .size(100.dp),
                imageVector = Icons.Outlined.CheckCircle,
                contentDescription = "Check",
                tint = MaterialTheme.colorScheme.primary
            )
            Text(
                "Monto retirado",
                fontSize = 30.sp
            )
        }
        Text(
            text = formatMoney(amount),
            fontSize = 40.sp
        )
        Column (
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Button(
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp),
                onClick = { navController.navigate("home") },
            ) {
                Text("Volver a inicio")
            }
        }
    }
}