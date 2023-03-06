package cl.phobos.pets.modules.home.ui

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import cl.phobos.pets.core.ui.components.AppTopBar
import cl.phobos.pets.modules.home.ui.components.HomeBottomContent
import cl.phobos.pets.modules.home.ui.components.HomeContent


@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(topBar = {
        AppTopBar(title = "My pets")
    }, content = {
        HomeContent(it)
    }, bottomBar = {
        HomeBottomContent(navController = navController)
    })
}



