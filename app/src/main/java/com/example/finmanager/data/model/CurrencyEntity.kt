package com.example.finmanager.data.model

import androidx.compose.runtime.Composable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "currency")
data class CurrencyEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "currency")
    val currency: String,
    @ColumnInfo(name = "rate")
    val rate: Double
)
