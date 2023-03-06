package cl.phobos.pets.modules.addpet.ui

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import cl.phobos.pets.core.routes.Routes
import com.google.android.material.datepicker.MaterialDatePicker
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

@HiltViewModel
class AddPetViewModel @Inject constructor():ViewModel() {

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _date = MutableLiveData<String>()
    val date: LiveData<String> = _date

    private val _sex = MutableLiveData<String>()
    val sex: LiveData<String> = _sex

    private val _kind = MutableLiveData<String>()
    val kind: LiveData<String> = _kind

    private val _color = MutableLiveData<String>()
    val color: LiveData<String> = _color

    private val _race = MutableLiveData<String>()
    val race: LiveData<String> = _race


    fun onNameChanged(value:String){
        _name.value = value;
    }
    fun onDateChanged(value:String){
        _date.value = value;
    }
    fun onSexChanged(value:String){
        _sex.value = value;
    }
    fun onKindChanged(value:String){
        _kind.value = value;
    }
    fun onColorChanged(value:String){
        _color.value = value;
    }
    fun onRaceChanged(value:String){
        _race.value = value;
    }


    fun showDatePicker(context: Context) {

        val year: Int
        val month: Int
        val day: Int

        val calendar = Calendar.getInstance()
        year = calendar.get(Calendar.YEAR)
        month = calendar.get(Calendar.MONTH)
        day = calendar.get(Calendar.DAY_OF_MONTH)
        calendar.time = Date()


        val datePickerDialog = DatePickerDialog(
            context,
            { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                _date.value = "$dayOfMonth-$month-$year"
            }, year, month, day
        ).show()

    }

    fun navigateToAddImages(navController: NavHostController) {
        navController.navigate(Routes.AddImagesRoute.route)
    }

}