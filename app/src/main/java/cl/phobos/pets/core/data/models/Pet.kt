package cl.phobos.pets.core.data.models

import androidx.room.PrimaryKey

data class Pet(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val date: String,
    val sex: String,
    val kind: String,
    val color: String,
    val race: String,
    val imagePath :String
) {
}