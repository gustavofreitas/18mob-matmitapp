package br.com.example.marmitapp.view.fragment.productlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import br.com.example.domain.entity.Product
import br.com.example.marmitapp.R
import br.com.example.marmitapp.view.fragment.productlist.ProductListFragmentDirections
import kotlinx.android.synthetic.main.item_product_list.view.*

class ProductListAdapter(
    private val dataSource: List<Product>,
    private val goToNext: (Product) -> Unit
): RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_product_list, parent, false)

        return ProductListViewHolder(
            view
        )
    }

    override fun getItemCount(): Int = dataSource.size

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        dataSource[position].run {
            configLine(this, holder)
        }
    }

    private fun configLine(product: Product, holder: ProductListViewHolder) {

        holder.apply {
            tvName.text = product.name
            tvDescription.text = product.description
            tvPrice.text = "R$ %.2f".format(product.price)
            view.setOnClickListener {
                goToNext(product)
            }
        }
    }

    class ProductListViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val tvName = view.tvProductName
        val tvDescription = view.tvProductDescription
        val tvPrice = view.tvPrice
    }
}