package cl.phobos.pets.core.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import cl.phobos.pets.core.data.models.Pet
import kotlinx.coroutines.flow.Flow


@Dao
interface PetDAO {

    @Query("SELECT * FROM Pet")
    fun getPets(): Flow<List<Pet>>

    @Insert
    suspend fun addPet(pet: Pet)

}