package br.com.example.core.navigation

import android.content.Context
import android.content.Intent

object HomeNavigation {
    fun toSupplierProductList(context: Context, id: String ){
        Intent(SupplierNavigation.PRODUCT_LIST_ACTION).also{
            it.putExtra(SupplierNavigation.SUPPLIER_ID, id)
            context.startActivity(it)
        }
    }
}