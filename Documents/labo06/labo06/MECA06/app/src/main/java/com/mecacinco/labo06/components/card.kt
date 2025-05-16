package com.mecacinco.labo06.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mecacinco.labo06.data.libros
import androidx.compose.foundation.lazy.items


@Composable
fun card(
    nombre: String,
    autor: String
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Column(
            modifier = Modifier.fillMaxWidth().padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
            Text("Nombre del libro: $nombre")
            Text("Nombre del autor: $autor")
        }
    }
}

@Composable
fun listaLibross() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        items(libros) { libro ->
            card(
                nombre = libro.nombre,
                autor = libro.autor
            )
        }
    }
}

@Preview( showBackground = true)
@Composable
fun prev(){
    listaLibross()
}