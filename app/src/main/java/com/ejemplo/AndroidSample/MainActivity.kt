package com.ejemplo.AndroidSample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ejemplo.AndroidSample.ui.theme.AndroidSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidSampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CurrencyConverter(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CurrencyConverter(modifier: Modifier = Modifier) {
    // Estado para guardar lo que escribe el usuario
    var dollarInput by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Instrucción
        Text(text = "Conversor de Dólares a Euros")

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para ingresar dólares
        TextField(
            value = dollarInput,
            onValueChange = { dollarInput = it },
            label = { Text("Dólares") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para convertir
        Button(onClick = {
            val dollars = dollarInput.toDoubleOrNull() ?: 0.0
            val euros = dollars * 0.92  // Tipo de cambio aproximado
            result = "$dollars USD = %.2f EUR".format(euros)
        }) {
            Text("Convertir")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Texto con el resultado
        if (result.isNotEmpty()) {
            Text(text = result, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CurrencyConverterPreview() {
    AndroidSampleTheme {
        CurrencyConverter()
    }
}
