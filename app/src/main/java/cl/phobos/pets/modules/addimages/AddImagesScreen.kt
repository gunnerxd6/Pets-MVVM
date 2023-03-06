package cl.phobos.pets.modules.addimages

import android.net.Uri
import android.widget.Space
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import cl.phobos.pets.core.ui.components.AppTopBar
import coil.compose.rememberAsyncImagePainter
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip

@Composable
fun AddImagesScreen() {
    Scaffold(
        topBar = {
            AppTopBar(title = "Add images")
        },
        content = { Content(it) }
    )
}

@Composable
fun Content(paddingValues: PaddingValues, viewModel: AddImagesViewModel = hiltViewModel()) {
    val galleryLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
            viewModel.setImages(it)
        }

    val image: Uri? by viewModel.image.observeAsState(initial = Uri.EMPTY)
    Column(
        modifier= Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { galleryLauncher.launch("image/*") },
            modifier = Modifier
                .wrapContentSize()
                .padding(10.dp)
        ) {
            Text(text = "Pick Image From Gallery")
        }
        if(image!= null && image != Uri.EMPTY){
            Image(
                painter = rememberAsyncImagePainter(image),
                contentScale = ContentScale.FillWidth,
                contentDescription = "",

                modifier = Modifier
                    .size(200.dp)
                    .clip(shape = RoundedCornerShape(25.dp))
            )
            Spacer(modifier = Modifier.height(25.dp))
            Button(onClick = { /*TODO*/ }) {
                Text("Save")
            }
        }

    }

}