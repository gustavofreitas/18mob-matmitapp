package br.com.example.coordinator

import android.app.Activity
import android.content.Intent
import br.com.example.supplier.navigator.SupplierNavigator
import br.com.example.supplier.view.SupplierActivity

class SupplierCoordinator: SupplierNavigator {

    override fun goToSupplierDetails(activity: Activity) {

        val intent = Intent(activity, SupplierActivity::class.java)

        activity.startActivity(intent)

    }


}