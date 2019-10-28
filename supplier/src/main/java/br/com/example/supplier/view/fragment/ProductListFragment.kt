package br.com.example.supplier.view.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import br.com.example.supplier.R
import kotlinx.android.synthetic.main.fragment_product_list.*

/**
 * A simple [Fragment] subclass.
 */
class ProductListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }



    private fun initView() {
        ibExit.setOnClickListener {
            activity?.finish()
        }
        btGoToSelectedProdiuct.setOnClickListener {
            findNavController().navigate(R.id.action_productListFragment_to_selectedProductFragment)
        }
    }
}
