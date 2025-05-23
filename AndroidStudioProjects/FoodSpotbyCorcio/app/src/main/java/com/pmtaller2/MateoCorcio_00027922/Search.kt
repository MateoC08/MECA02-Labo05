package com.pmtaller2.MateoCorcio_00027922

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pmtaller2.MateoCorcio_00027922.components.DishCard
import com.pmtaller2.MateoCorcio_00027922.components.SimpleSearchBar
import com.pmtaller2.MateoCorcio_00027922.models.Dish
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun searchView(
    dishes: List<Dish>,
    restaurantName: String,
    onBack: () -> Unit,
    addToCart: (String) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color.White,
                ),
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        IconButton(onClick = { onBack() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Regresar",
                                tint = Color.White
                            )
                        }
                        Text(restaurantName)
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            SimpleSearchBar(
                query = searchQuery,
                onQueryChange = { searchQuery = it },
                onSearch = {},
                searchResults = dishes.map { it.name }
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .border(5.dp, Color.Black, RoundedCornerShape(8.dp))
                    .padding(5.dp)
                    .fillMaxSize()
            ) {
                dishes
                    .filter { it.name.contains(searchQuery, ignoreCase = true) }
                    .forEach { dish ->
                        item {
                            DishCard(
                                name = dish.name,
                                description = dish.description,
                                imageUrl = dish.imageUrl,
                                onAddToCart = { addToCart(dish.name) }
                            )
                        }
                    }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchViewPreview() {
    val sampleDishes = listOf(
        Dish(id = 1, name = "Tacos al Pastor", description = "Tacos con carne de cerdo y piña", imageUrl = "https://www.example.com/taco.jpg"),
        Dish(id = 2, name = "Enchiladas", description = "Enchiladas rojas con pollo", imageUrl = "https://www.example.com/enchilada.jpg"),
        Dish(id = 3, name = "Tamales", description = "Tamales rellenos de carne de cerdo", imageUrl = "https://www.example.com/tamale.jpg")
    )

    searchView(
        dishes = sampleDishes,
        restaurantName = "Restaurante Mexicano",
        onBack = {  },
        addToCart = { dishName -> }
    )
}

