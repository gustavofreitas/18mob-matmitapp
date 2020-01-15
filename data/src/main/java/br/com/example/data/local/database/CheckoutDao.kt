package br.com.example.data.local.database

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import br.com.example.data.local.model.CheckoutCache

interface CheckoutDao {
    @Insert
    fun insert(checkout: CheckoutCache): CheckoutCache

    @Transaction
    fun update(checkout: CheckoutCache): CheckoutCache{
        delete()
        return insert(checkout)
    }

    @Query("SELECT * FROM checkout LIMIT 1")
    fun get(): CheckoutCache

    @Query("DELETE FROM checkout")
    fun delete()

}