package com.pmtaller2.MateoCorcio_00027922.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.pmtaller2.MateoCorcio_00027922.models.Dish
import com.pmtaller2.MateoCorcio_00027922.models.Restaurant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestCard(
    categoryName: String,
    restaurants: List<Restaurant>,
    onRestaurantClick: (List<Dish>, String) -> Unit,

    ) {
    val filteredRestaurants = restaurants.filter { it.categories.contains(categoryName) }

    if (filteredRestaurants.isEmpty()) return

    Text(
        text = categoryName,
        style = MaterialTheme.typography.titleLarge.copy(
            color = Color.Black,
            fontWeight = FontWeight.Bold
        ),
        modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 4.dp)
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(filteredRestaurants.size, key = { filteredRestaurants[it].id }) { index ->
                val restaurant = filteredRestaurants[index]
                Column(
                    modifier = Modifier
                        .width(160.dp)
                        .padding(4.dp)
                        .clickable { onRestaurantClick(restaurant.menu, restaurant.name) }
                ) {
                    Text(
                        text = restaurant.name,
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(bottom = 8.dp)
                    )
                    AsyncImage(
                        model = restaurant.imageUrl,
                        contentDescription = "Imagen del restaurante",
                        modifier = Modifier.size(150.dp),
                        contentScale = ContentScale.Crop,
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DishCard(
    name: String,
    description: String,
    imageUrl: String,
    onAddToCart: () -> Unit
) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "Imagen del platillo",
                modifier = Modifier
                    .size(120.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {
                        onAddToCart()
                        Toast.makeText(context, "Agregado al carrito", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                ) {
                    Text("Agregar al Carrito", color = Color.White)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RestCardPreview() {
    val sampleDishes = listOf(
        Dish(id = 1, name = "Tacos al Pastor", description = "Tacos con carne de cerdo y piña", imageUrl = "https://www.example.com/taco.jpg"),
        Dish(id = 2, name = "Enchiladas", description = "Enchiladas rojas con pollo", imageUrl = "https://www.example.com/enchilada.jpg")
    )

    val sampleRestaurants = listOf(
        Restaurant(
            id = 1,
            name = "Restaurante Mexicano",
            description = "Restaurante especializado en comida mexicana",
            imageUrl = "https://www.example.com/restaurant.jpg",
            categories = listOf("Mexicana"),
            menu = sampleDishes
        ),
        Restaurant(
            id = 2,
            name = "Restaurante Italiano",
            description = "Restaurante especializado en comida italiana",
            imageUrl = "https://www.example.com/restaurant2.jpg",
            categories = listOf("Italiana"),
            menu = sampleDishes
        )
    )

    Column(modifier = Modifier.padding(16.dp)) {
        RestCard(
            categoryName = "Mexicana",
            restaurants = sampleRestaurants,
            onRestaurantClick = { menu, name -> }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DishCardPreview() {
    DishCard(
        name = "Tacos al Pastor",
        description = "Deliciosos tacos con carne de cerdo, piña, y salsa roja.",
        imageUrl = "https://www.example.com/taco.jpg",
        onAddToCart = { /* Acción al agregar al carrito */ }
    )
}



