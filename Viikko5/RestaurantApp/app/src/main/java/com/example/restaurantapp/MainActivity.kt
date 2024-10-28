package com.example.restaurantapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.restaurantapp.ui.theme.RestaurantAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun App() {
    val navController = rememberNavController()
    RestaurantAppTheme {
        Scaffold(
            topBar =
            {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.primaryContainer,
                    ),
                    title = {
                        Text(text = "Find a Restaurant")
                    },
                )
            }
        ) { innerPadding ->
            NavHost(navController, startDestination = "home", Modifier.padding(innerPadding)) {
                composable("home") { HomeScreen(navController) }
                composable(
                    "info/{restaurantName}",
                    arguments = listOf(navArgument("restaurantName") { type = NavType.StringType })
                ) { backStackEntry ->
                    val restaurantName = backStackEntry.arguments?.getString("restaurantName")
                    RestaurantInfo(restaurantName) // Pass the restaurant name
                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    var searchText by remember { mutableStateOf("") }
    val filteredRestaurants = restaurants.filter { restaurant ->
        restaurant.name.contains(searchText, ignoreCase = true)
    }
    Column() {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text("Search") })
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ){
            items(filteredRestaurants) { restaurant ->
                RestaurantCard(restaurant, navController)
            }
        }
    }
    }

@Composable
fun RestaurantCard(restaurant: Restaurant, navController: NavHostController) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .clickable(
                onClick = { navController.navigate("info/${restaurant.name}") }
            )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = restaurant.name,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = restaurant.address,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun RestaurantInfo(RestaurantName: String? ) {
    val restaurant = restaurants.find { it.name == RestaurantName }
    if (restaurant != null) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = restaurant.name,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = restaurant.address,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = restaurant.cuisine,
                    fontStyle = FontStyle.Italic
                )
                Text(text = "Rating: ${restaurant.rating}")
            }
        }
    } else {
        Text(text = "Restaurant not found")
    }
}



// Data class for Restaurant
data class Restaurant(
    val name: String,
    val address: String,
    val rating: Double,
    val cuisine: String
)

var restaurants = listOf(
    Restaurant("The Gourmet Kitchen", "123 Food St.", 4.5, "Italian"),
    Restaurant("Sushi World", "456 Sushi Ave.", 4.8, "Japanese"),
    Restaurant("Taco Paradise", "789 Taco Blvd.", 4.2, "Mexican"),
    Restaurant("Burger Heaven", "321 Burger Ln.", 4.0, "American"),
    Restaurant("Pasta House", "147 Noodle St.", 4.3, "Italian"),
    Restaurant("Spicy Curry Palace", "852 Spice Rd.", 4.7, "Indian"),
    Restaurant("Le Petit Bistro", "963 French St.", 4.6, "French"),
    Restaurant("Wok 'n' Roll", "258 Noodle Ave.", 4.1, "Chinese"),
    Restaurant("Pizza Planet", "159 Slice Blvd.", 3.9, "Italian"),
    Restaurant("The BBQ Shack", "753 Grill Ln.", 4.4, "American"),
    Restaurant("Ramen Kingdom", "357 Ramen St.", 4.9, "Japanese"),
    Restaurant("Café Mocha", "123 Coffee Rd.", 4.0, "Cafe"),
    Restaurant("Viva la Vegan", "456 Green St.", 4.6, "Vegan"),
    Restaurant("El Toro Loco", "789 Fiesta Ave.", 4.3, "Mexican"),
    Restaurant("Dim Sum Delight", "159 Dumpling Ln.", 4.5, "Chinese"),
    Restaurant("The Greek Taverna", "258 Olive St.", 4.7, "Greek"),
    Restaurant("Kebab Palace", "963 Spice St.", 4.3, "Middle Eastern"),
    Restaurant("The Hot Pot Spot", "654 Boil Ave.", 4.2, "Chinese"),
    Restaurant("Falafel Corner", "321 Vegan Blvd.", 4.0, "Middle Eastern"),
    Restaurant("Seaside Sushi", "753 Ocean Ave.", 4.8, "Japanese"),
    Restaurant("The Taco Stand", "987 Fiesta St.", 3.8, "Mexican"),
    Restaurant("Steakhouse Supreme", "654 Meat Ln.", 4.9, "American"),
    Restaurant("Pho Haven", "258 Soup Ave.", 4.4, "Vietnamese"),
    Restaurant("The Sushi Spot", "951 Fish Blvd.", 4.2, "Japanese"),
    Restaurant("The Vegan Joint", "753 Plant Ave.", 4.7, "Vegan")
)
