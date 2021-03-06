package br.com.example.marmitapp.view.fragment.supplierlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.example.marmitapp.R
import br.com.example.marmitapp.model.SupplierUIModel
import kotlinx.android.synthetic.main.item_supplier_list.view.*

class SupplierListAdapter(
    val dataSource: List<SupplierUIModel?>,
    val goToNext: (String) -> Unit): Adapter<SupplierListAdapter.SupplierListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupplierListViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_supplier_list, parent, false)

        return SupplierListViewHolder(
            view
        )
    }

    override fun getItemCount(): Int = dataSource.size

    override fun onBindViewHolder(holder: SupplierListViewHolder, position: Int) {
        dataSource[position]?.run {
            configLine(this, holder)
        }
    }

    private fun configLine(supplier: SupplierUIModel, holder: SupplierListViewHolder) {

        holder.apply {
            title.text = supplier.name
            view.setOnClickListener {
                goToNext(supplier.id)
            }
        }
    }

    class SupplierListViewHolder(val view: View): ViewHolder(view){
        val photo = view.ivSupplierLogo
        val title = view.tvSupplierName


    }
}