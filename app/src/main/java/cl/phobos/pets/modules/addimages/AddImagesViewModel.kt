package cl.phobos.pets.modules.addimages

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddImagesViewModel @Inject constructor(): ViewModel() {

    private val _image = MutableLiveData<Uri?>()
    val image: LiveData<Uri?> = _image

    fun setImages(data:Uri?){
        _image.value = data
    }

}