package com.pmtaller2.mecados05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pmtaller2.mecados05.ui.theme.MECADOS05Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MECADOS05Theme {
               navLo()
            }
        }
    }
}


@Composable
fun HomeView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Laboratorio 05")
        Button(onClick = { navController.navigate("ScreenA") }) {
            Text("Ver lista TODO")
        }
        Button(onClick = { navController.navigate("screenB") }) {
            Text("Ver información de sensores")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MECADOS05Theme {
      HomeView(navController = NavController( context = MainActivity() ))
    }
}