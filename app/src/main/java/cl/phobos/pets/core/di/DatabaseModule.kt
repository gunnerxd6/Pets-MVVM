package cl.phobos.pets.core.di

import android.content.Context
import androidx.room.Room
import cl.phobos.pets.core.data.PetDAO
import cl.phobos.pets.core.data.PetDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun providePetDAO(petDatabase: PetDatabase): PetDAO{
        return petDatabase.petDAO()
    }

    @Provides
    @Singleton
    fun providePetDatabase(@ApplicationContext appContext: Context): PetDatabase{
        return Room.databaseBuilder(appContext, PetDatabase::class.java, name = "PetDatabase").build()
    }


}