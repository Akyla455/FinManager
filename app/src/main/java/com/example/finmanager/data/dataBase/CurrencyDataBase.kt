package com.example.finmanager.data.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.finmanager.data.model.CurrencyEntity

const val DATABASE_VERSION = 1

@Database(entities = [CurrencyEntity::class], version = DATABASE_VERSION, exportSchema = true)
abstract class CurrencyDataBase: RoomDatabase(){
    abstract fun currencyDao(): CurrencyDao

}