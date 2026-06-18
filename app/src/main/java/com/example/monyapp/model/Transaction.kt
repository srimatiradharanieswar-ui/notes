package com.example.monyapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val amount: Double,
    val date: Long,
    val type: TransactionType,
    val category: String
)

enum class TransactionType {
    INCOME, EXPENSE
}
