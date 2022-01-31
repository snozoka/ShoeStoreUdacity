package com.example.shoestoreudacity.screens.shoe_listings

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.example.shoestoreudacity.R
import com.example.shoestoreudacity.databinding.ShoeListFragmentBinding
import com.example.shoestoreudacity.models.Shoes
import com.example.shoestoreudacity.screens.shoe_details.ShoeDetailsFragmentArgs
import java.nio.channels.Selector

class ShoeListFragment : Fragment() {


    private lateinit var viewModel: ShoeListViewModel
    private lateinit var _binding: ShoeListFragmentBinding
    private lateinit var shoeSelector: Selector
    private val model: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater,R.layout.shoe_list_fragment, container, false)
        _binding.floatingActionButtonGoToShoeDetail.setOnClickListener{view: View ->
            Navigation.findNavController(view).navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment(
                _binding.textViewShoeListShoeName.toString(),  _binding.textViewShoeListShoeCompany.toString().toFloat(),
                _binding.textViewShoeListShoeSize.toString(),_binding.textViewShoeListShoeDescription.toString()
            ))

            val shoeDetailsFragmentArgs by navArgs<ShoeDetailsFragmentArgs>()
            val shoeItemLayoutBinding =
                ShoeListFragmentBinding.inflate(LayoutInflater.from(requireContext()),_binding.linearLayoutShoes, false)
            shoeItemLayoutBinding.apply {
                textViewShoeListShoeName.text = shoeDetailsFragmentArgs.shoeName
                textViewShoeListShoeCompany.text = shoeDetailsFragmentArgs.shoeCompany
                textViewShoeListShoeSize.text = shoeDetailsFragmentArgs.shoeSize.toString()
                textViewShoeListShoeDescription.text = shoeDetailsFragmentArgs.shoeDescription
            }
            _binding.linearLayoutShoes.addView(shoeItemLayoutBinding.root)
        }
        setHasOptionsMenu(true)

        return _binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
    private fun getViews() {

    }

}