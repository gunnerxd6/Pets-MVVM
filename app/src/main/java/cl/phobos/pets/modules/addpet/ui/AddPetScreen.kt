package cl.phobos.pets.modules.addpet.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import cl.phobos.pets.core.ui.components.AppTopBar

@Composable
fun AddPetScreen(navController: NavHostController) {

    Scaffold(
        topBar = { AppTopBar(title = "Add new pet") },
        content = { Content(it, navController = navController) })

}

@Composable
fun Content(
    paddingValues: PaddingValues,
    viewModel: AddPetViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val activity = LocalContext.current
    val name: String by viewModel.name.observeAsState(initial = "")
    val date: String by viewModel.date.observeAsState(initial = "")
    val sex: String by viewModel.sex.observeAsState(initial = "")
    val kind: String by viewModel.kind.observeAsState(initial = "")
    val color: String by viewModel.color.observeAsState(initial = "")
    val race: String by viewModel.race.observeAsState(initial = "")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        OutlinedTextField(modifier = Modifier.fillMaxWidth(),
            value = name,
            onValueChange = { viewModel.onNameChanged(it) },
            label = { Text(text = "Name") })
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(

                value = date,
                enabled = false,
                onValueChange = { viewModel.onDateChanged(it) },
                label = { Text(text = "Date of Birth") })

            Button(

                onClick = {

                    viewModel.showDatePicker(context = activity)
                }) {
                Text("Pick date")
            }
        }
        OutlinedTextField(modifier = Modifier.fillMaxWidth(),
            value = sex,
            onValueChange = { viewModel.onSexChanged(it) },
            label = { Text(text = "Sex") })
        OutlinedTextField(modifier = Modifier.fillMaxWidth(),
            value = kind,
            onValueChange = { viewModel.onKindChanged(it) },
            label = { Text(text = "Kind") })
        OutlinedTextField(modifier = Modifier.fillMaxWidth(),
            value = color,
            onValueChange = { viewModel.onColorChanged(it) },
            label = { Text(text = "Color") })
        OutlinedTextField(modifier = Modifier.fillMaxWidth(),
            value = race,
            onValueChange = { viewModel.onRaceChanged(it) },
            label = { Text(text = "Race") })
        Button(onClick = { viewModel.navigateToAddImages(navController = navController) }) {
            Text("Next")
        }

    }

}