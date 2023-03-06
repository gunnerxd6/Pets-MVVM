package cl.phobos.pets.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.phobos.pets.core.data.models.Pet

@Database(entities = [Pet::class], version = 1)
abstract class PetDatabase :RoomDatabase(){
    abstract fun petDAO(): PetDAO
}