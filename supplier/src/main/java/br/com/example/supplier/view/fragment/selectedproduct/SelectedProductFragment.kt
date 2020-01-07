package br.com.example.supplier.view.fragment.selectedproduct

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.example.core.model.Product

import br.com.example.supplier.R
import kotlinx.android.synthetic.main.fragment_selected_product.*

class SelectedProductFragment : Fragment() {

    //val args:

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selected_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        initView()
    }

    private fun initView() {
        val product = arguments?.get("product") as? Product

        product?.let{
            tvProductName.text = product.name
            tvDescription.text = product.description

            var productItens: String = ""

            it.content.forEach {
                productItens += "$it, "
            }

            //tvItensList.text = productItens
        }
        ibBackButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
