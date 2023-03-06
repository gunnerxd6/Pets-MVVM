package cl.phobos.pets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.phobos.pets.core.routes.Routes
import cl.phobos.pets.modules.addimages.AddImagesScreen
import cl.phobos.pets.modules.addpet.ui.AddPetScreen
import cl.phobos.pets.modules.home.ui.HomeScreen
import cl.phobos.pets.ui.theme.PetsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Routes.HomeRoute.route
                        ){
                        composable(route = Routes.HomeRoute.route){
                            HomeScreen(navController = navController)
                        }
                        composable(route = Routes.AddPetRoute.route){
                            AddPetScreen(navController = navController)
                        }
                        composable(route = Routes.AddImagesRoute.route){
                            AddImagesScreen()
                        }
                    }
                }
            }
        }
    }
}

