package com.pmtaller2.MateoCorcio_00027922

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pmtaller2.MateoCorcio_00027922.components.RestCard
import com.pmtaller2.MateoCorcio_00027922.models.restaurants
import com.pmtaller2.MateoCorcio_00027922.models.categories
import androidx.compose.runtime.*
import com.pmtaller2.MateoCorcio_00027922.models.Dish


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView0(
    onNavigateToSearch: (List<Dish>, String) -> Unit
) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Listados", "Busquedas", "Mis Ordenes")
    val selectedIcons = listOf(Icons.Filled.Home, Icons.Filled.Search, Icons.Filled.Star)
    val unselectedIcons = listOf(Icons.Outlined.Home, Icons.Outlined.Search, Icons.Outlined.Info)

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Black,
                titleContentColor = Color.White,
            ),
            title = { Text("FoodSpot by Corcio") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        categories.forEach { category ->
            val restaurantsInCategory = restaurants.filter { restaurant ->
                restaurant.categories.any { it.equals(category.name, ignoreCase = true) }
            }
            if (restaurantsInCategory.isNotEmpty()) {
                RestCard(
                    categoryName = category.name,
                    restaurants = restaurantsInCategory,
                    onRestaurantClick = { selectedMenu, restaurantName ->
                        onNavigateToSearch(selectedMenu, restaurantName)
                    }
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun SmallTopAppBarExamplePreview() {
    HomeView0(
        onNavigateToSearch = { selectedMenu, restaurantName -> }
    )
}



