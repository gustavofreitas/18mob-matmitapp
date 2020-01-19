package br.com.example.data.local.converters

import androidx.room.TypeConverter
import br.com.example.data.local.model.ProductCache
import com.google.gson.Gson

class ProductListConverter {

    @TypeConverter
    fun listToJson(value: List<ProductCache>?): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<ProductCache>? {
        val objects = Gson().fromJson(value, Array<ProductCache>::class.java) as Array<ProductCache>
        return objects.toList()
    }

}