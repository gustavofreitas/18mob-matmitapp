package br.com.example.supplier.view.fragment.product.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import br.com.example.core.model.Product
import br.com.example.supplier.R
import kotlinx.android.synthetic.main.item_product_list.view.*

class ProductListAdapter(
    private val dataSource: List<Product>,
    private val fragmentContainer: Fragment
): RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_product_list, parent, false)

        return ProductListViewHolder(view)
    }

    override fun getItemCount(): Int = dataSource.size

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        dataSource[position]?.run {
            configLine(this, holder)
        }
    }

    private fun configLine(product: Product, holder: ProductListViewHolder) {

        holder.apply {
            name.text = product.name
            description.text = product.description
            view.setOnClickListener {
                fragmentContainer.findNavController().navigate(R.id.action_productListFragment_to_selectedProductFragment)
            }
        }
    }

    class ProductListViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val name = view.tvProductName
        val description = view.tvProductDescription
    }
}