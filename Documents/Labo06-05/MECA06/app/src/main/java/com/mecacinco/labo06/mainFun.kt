package com.mecacinco.labo06

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mecacinco.labo06.components.card
import kotlinx.coroutines.delay
import androidx.compose.foundation.lazy.items


suspend fun delayxd(): List<Pair<String, String>> {
    delay(3000)
    return List(8) { "Luna de pluton" to "Dross" }
}

@Composable
fun action() {
    val librosState = remember { mutableStateOf<List<Pair<String, String>>?>(null) }
    var loading by remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(loading) {
        if (loading) {
            val data = delayxd()
            librosState.value = data
            snackbarHostState.showSnackbar("Datos cargados correctamente")
            loading = false
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    loading = true
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Get Data")
            }

            Spacer(modifier = Modifier.height(16.dp))

            when {
                loading && librosState.value == null -> {
                    Spacer(modifier = Modifier.height(300.dp))
                    Text("Cargando datos...")
                    CircularProgressIndicator()
                }
                librosState.value != null -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(librosState.value!!) { (nombre, autor) ->
                            card(nombre = nombre, autor = autor)
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewActionWithDataLoad() {
    action()
}
