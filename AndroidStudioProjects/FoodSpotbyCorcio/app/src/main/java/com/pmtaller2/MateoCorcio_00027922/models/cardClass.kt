package com.pmtaller2.MateoCorcio_00027922.models

data class Dish(
    val id: Int,
    val name : String,
    val description : String,
    val imageUrl: String
)

data class Restaurant(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val categories: List<String>,
    val menu: List<Dish>
)

data class Category(
    val id: Int,
    val name: String
)
