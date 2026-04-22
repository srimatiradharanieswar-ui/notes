package com.example.monyapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.monyapp.model.Transaction

@Database(entities = [Transaction::class], version = 1, exportSchema = false)
abstract class TransactionDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
}
