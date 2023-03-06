package cl.phobos.pets.modules.home.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cl.phobos.pets.core.routes.Routes

@Composable
fun HomeBottomContent(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        FloatingActionButton(
            modifier = Modifier.align(alignment = Alignment.BottomEnd),
            onClick = { navController.navigate(Routes.AddPetRoute.route) }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add pet")
        }
    }
}