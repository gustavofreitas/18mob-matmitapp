package br.com.example.data.local.converters

import androidx.room.TypeConverter
import br.com.example.data.local.model.ProductItemCache
import com.google.gson.Gson

class ProductItemConverter {

    @TypeConverter
    fun listToJson(value: List<ProductItemCache>?): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<ProductItemCache>? {
        val objects = Gson().fromJson(value, Array<ProductItemCache>::class.java) as Array<ProductItemCache>
        return objects.toList()
    }

}