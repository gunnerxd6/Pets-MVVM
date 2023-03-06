package cl.phobos.pets.core.ui.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun AppTopBar(title:String){
    TopAppBar {
        Text(title, fontSize = 26.sp, fontWeight = FontWeight.SemiBold)
    }
}