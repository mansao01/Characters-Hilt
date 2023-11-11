package com.mansao.characterhilt.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mansao.characterhilt.data.local.model.CharacterModel

@Database(entities = [CharacterModel::class], version = 1, exportSchema = false)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}