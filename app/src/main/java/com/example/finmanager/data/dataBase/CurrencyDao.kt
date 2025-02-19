package com.example.finmanager.data.dataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.finmanager.data.model.CurrencyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyDao {

    @Query("SELECT * FROM currency ORDER BY id DESC")
    suspend fun getCurrency(): List<CurrencyEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrency(currencyEntity: List<CurrencyEntity>)

    @Update
    suspend fun updateCurrency(currencyEntity: List<CurrencyEntity>): Int

    @Delete
    suspend fun deleteCurrency(currencyEntity: CurrencyEntity): Int
}