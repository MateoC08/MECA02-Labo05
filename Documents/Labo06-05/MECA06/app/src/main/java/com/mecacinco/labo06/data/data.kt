package com.mecacinco.labo06.data

data class Libro(
    val id: Int,
    val nombre : String,
    val autor : String
)

val libros = listOf(
    Libro(
        id = 1,
        nombre = "Luena de saturno",
        autor = "Dross :v"
        ),
    Libro(
        id = 2,
        nombre = "Luna de pluton",
        autor = "dross"
    ),
    Libro(
        id = 3,
        nombre = "Luna de urano",
        autor = "dross"
    ),
    Libro(
        id = 4,
        nombre = "Luna de neptuno",
        autor = "dross"
    ),
    Libro(
        id = 5,
        nombre = "Luna de tierra",
        autor = "dross"
    )
)

