package com.example.shoestoreudacity.screens.shoe_listings

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.example.shoestoreudacity.R
import com.example.shoestoreudacity.databinding.ShoeListFragmentBinding
import com.example.shoestoreudacity.screens.shoe_details.ShoeDetailsFragmentArgs

class ShoeListFragment : Fragment() {


    private val viewModelShared: SharedShoeViewModel by activityViewModels()
    private lateinit var _binding: ShoeListFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var shoeDescriptionHere = ""
        var shoeCompanyHere= ""
        //viewModelShared = ViewModelProvider(this).get(SharedShoeViewModel::class.java)
        _binding = DataBindingUtil.inflate(inflater,R.layout.shoe_list_fragment, container, false)
//        _binding.shoeListViewModel = viewModelShared
//        _binding.lifecycleOwner = this

        viewModelShared.shoesListLiveData.observe(viewLifecycleOwner, Observer{ shoe ->
            _binding.textViewShoeListShoeName.text = shoe[1].name
            _binding.textViewShoeListShoeSize.text = shoe[1].size.toString()
            shoeDescriptionHere = shoe[1].description
            shoeCompanyHere = shoe[1].company
        })

        _binding.floatingActionButtonGoToShoeDetail.setOnClickListener{view: View ->
            Navigation.findNavController(view).navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment(
                _binding.textViewShoeListShoeName.toString(),_binding.textViewShoeListShoeSize.toString().toFloat(),
                shoeCompanyHere,
                shoeDescriptionHere
            ))

            val shoeDetailsFragmentArgs by navArgs<ShoeDetailsFragmentArgs>()
            val shoeItemLayoutBinding =
                ShoeListFragmentBinding.inflate(LayoutInflater.from(requireContext()),_binding.linearLayoutShoes, false)
            shoeItemLayoutBinding.apply {
                _binding.textViewShoeListShoeName.text = shoeDetailsFragmentArgs.shoeName
                //textViewShoeListShoeCompany.text = shoeDetailsFragmentArgs.shoeCompany
                _binding.textViewShoeListShoeSize.text = shoeDetailsFragmentArgs.shoeSize.toString()
                //textViewShoeListShoeDescription.text = shoeDetailsFragmentArgs.shoeDescription
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


}