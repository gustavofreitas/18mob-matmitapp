package br.com.example.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.example.data.local.model.CheckoutCache

@Database(version = 1, entities = [CheckoutCache::class])
abstract class CheckoutDataBase: RoomDatabase() {
    abstract fun checkoutDao(): CheckoutDao

    companion object{
        fun createDataBase(context: Context): CheckoutDao {
            return Room
                .databaseBuilder(context, CheckoutDataBase::class.java, "Checkout.db")
                .build()
                .checkoutDao()
        }
    }
}