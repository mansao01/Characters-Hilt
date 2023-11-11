package com.mansao.characterhilt.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mansao.characterhilt.data.local.model.CharacterModel
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(character: CharacterModel)

    @Delete
    suspend fun delete(character: CharacterModel)

    @Query("SELECT * FROM charactermodel")
    fun getAllCharacters(): Flow<List<CharacterModel>>

}