package com.example.shoestoreudacity.screens.shoe_details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.shoestoreudacity.R
import com.example.shoestoreudacity.databinding.ShoeDetailsFragmentBinding
import com.example.shoestoreudacity.models.Shoes
import com.example.shoestoreudacity.screens.shoe_listings.ShoeListViewModel
import timber.log.Timber

class ShoeDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = ShoeDetailsFragment()
    }

    private lateinit var viewModel: ShoeDetailsViewModel
    private lateinit var _binding: ShoeDetailsFragmentBinding
    private val model: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater,R.layout.shoe_details_fragment, container, false)
        _binding.buttonCancel.setOnClickListener(Navigation.createNavigateOnClickListener
            (R.id.action_shoeDetailsFragment_to_shoeListFragment))
        _binding.buttonSave.setOnClickListener{view: View ->
            saveShoeDetail()
            Navigation.findNavController(view).navigate(
                ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
        }
        model.shoesList.observe(viewLifecycleOwner, Observer<List<Shoes>> { item ->
            // Update the UI
            Timber.i("Item is: $item")
        })
        var args = ShoeDetailsFragmentArgs.fromBundle(requireArguments())

        return _binding.root
    }

    private fun saveShoeDetail(){
        Timber.i("Shoe details saved")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ShoeDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}