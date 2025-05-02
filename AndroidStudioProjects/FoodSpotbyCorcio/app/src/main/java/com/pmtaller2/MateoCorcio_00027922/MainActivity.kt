package com.pmtaller2.MateoCorcio_00027922

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.pmtaller2.MateoCorcio_00027922.components.BottomNavBar
import com.pmtaller2.MateoCorcio_00027922.models.Dish
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

import com.pmtaller2.MateoCorcio_00027922.ui.theme.FoodSpotByCorcioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodSpotByCorcioTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var selectedItem by remember { mutableIntStateOf(0) }
    var selectedDishes by remember { mutableStateOf<List<Dish>>(emptyList()) }
    var restName by remember { mutableStateOf("") }

    val orders = remember { mutableStateListOf<String>() }

    Scaffold(
        bottomBar = {
            BottomNavBar(
                selectedItem = selectedItem,
                onItemSelected = { selectedItem = it }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            when (selectedItem) {
                0 -> HomeView0(
                    onNavigateToSearch = { dishes, restaurantName ->
                        selectedDishes = dishes
                        restName = restaurantName
                        selectedItem = 1
                    }
                )
                1 -> searchView(
                    dishes = selectedDishes,
                    restaurantName = restName,
                    onBack = { selectedItem = 0 },
                    addToCart = { dishName ->
                        orders.add(dishName)
                    }
                )
                2 -> OrdersView(
                    orders = orders,
                    onSearch = { },
                    onBack = { selectedItem = 0 }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}