package cl.phobos.pets.modules.home.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeContent(paddingValues: PaddingValues) {
    Column() {
        LazyColumn(){
            items(count = 10){
                Card() {
                    Row(){
                        Icon(
                            modifier = Modifier.weight(2f).width(100.dp).height(100.dp),
                            imageVector = Icons.Filled.Person, contentDescription = "Pet photo", tint = Color.Magenta)
                        Column(
                            modifier = Modifier.weight(4f)
                        ) {
                            Text("Name of pet")
                            Text("Next date of control: 11/10/2023")
                        }
                    }
                }
            }
        }
    }
}