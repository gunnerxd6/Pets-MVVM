package cl.phobos.pets.core.routes

sealed class Routes(val route:String){
    object HomeRoute:Routes(route = "home")
    object AddPetRoute:Routes(route = "add_pet")

    object AddImagesRoute:Routes(route = "add_images")
}
