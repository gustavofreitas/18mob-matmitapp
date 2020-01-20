package br.com.example.marmitapp.view.fragment.checkout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.example.domain.entity.Product
import br.com.example.marmitapp.R
import br.com.example.marmitapp.model.CheckoutUIModel
import kotlinx.android.synthetic.main.item_checkout_list.view.*

class CheckoutListAdapter(
    val dataSource: CheckoutUIModel
): RecyclerView.Adapter<CheckoutListAdapter.CheckoutListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckoutListViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_checkout_list, parent, false)

        return CheckoutListViewHolder(
            view
        )
    }

    override fun getItemCount(): Int = dataSource.productList.size

    override fun onBindViewHolder(holder: CheckoutListViewHolder, position: Int) {
        dataSource.productList[position]?.run {
            configLine(this, holder)
        }
    }

    private fun configLine(product: Product, holder: CheckoutListViewHolder) {
        holder.apply {
            name.text = product.name
            descr.text = product.description
            price.text = product.price.toString()
        }
    }

    class CheckoutListViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val name = view.tvProductName
        val descr = view.tvProductDescription
        val price = view.tvPrice
    }

}

