package br.com.example.home.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.example.home.R
import br.com.example.home.model.SupplierUIModel
import kotlinx.android.synthetic.main.item_supplier_list.view.*

class SupplierListAdapter(val dataSource: List<SupplierUIModel?>): Adapter<SupplierListAdapter.SupplierListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupplierListViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_supplier_list, parent, false)

        return SupplierListViewHolder(view)
    }

    override fun getItemCount(): Int = dataSource.size

    override fun onBindViewHolder(holder: SupplierListViewHolder, position: Int) {
        dataSource[position]?.apply {
             holder.title.text = name
        }
    }

    class SupplierListViewHolder(val view: View): ViewHolder(view){
        val photo = view.ivSupplierLogo
        val title = view.tvSupplierName
    }
}