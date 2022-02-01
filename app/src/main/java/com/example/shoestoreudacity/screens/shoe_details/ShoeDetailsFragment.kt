package com.example.shoestoreudacity.screens.shoe_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.shoestoreudacity.R
import com.example.shoestoreudacity.databinding.ShoeDetailsFragmentBinding
import com.example.shoestoreudacity.models.Shoes
import com.example.shoestoreudacity.screens.shoe_listings.SharedShoeViewModel
import timber.log.Timber

class ShoeDetailsFragment : Fragment() {

    private val viewModelShared: SharedShoeViewModel by activityViewModels()
    private lateinit var _binding: ShoeDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //viewModelShared = ViewModelProvider(this).get(ShoeDetailsViewModel::class.java)

        _binding = DataBindingUtil.inflate(inflater,R.layout.shoe_details_fragment, container, false)
        viewModelShared.addShoe(viewModelShared.addidasShoe)
        viewModelShared.addShoe(viewModelShared.jordanShoe)
        viewModelShared.addShoe(viewModelShared.pumaShoe)
        viewModelShared.addShoe(viewModelShared.asisShoe)
        viewModelShared.addShoe(viewModelShared.fubuShoe)
        viewModelShared.addShoe(viewModelShared.reebokShoe)


        _binding.buttonCancel.setOnClickListener(Navigation.createNavigateOnClickListener
            (R.id.action_shoeDetailsFragment_to_shoeListFragment))

        _binding.buttonSave.setOnClickListener{view: View ->
            val shoe = Shoes("",0.0,"","")
            shoe.name = _binding.editTextTextShoeName.toString()
            shoe.size = _binding.editTextTextShoeSize.toString().toDouble()
            shoe.company = _binding.editTextTextCompanyName.toString()
            shoe.description = _binding.editTextTextShoeDescription.toString()
            saveShoeDetail(shoe)
            Navigation.findNavController(view).navigate(
                ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
        }
//        viewModelShared.shoesList.observe(viewLifecycleOwner, Observer<List<Shoes>> { item ->
//            // Update the UI
//            Timber.i("Item is: $item")
//        })
        //var args = ShoeDetailsFragmentArgs.fromBundle(requireArguments())



        return _binding.root
    }

    private fun saveShoeDetail(shoe: Shoes){
        viewModelShared.addShoe(shoe)
        Timber.i("Shoe details saved")
    }


}