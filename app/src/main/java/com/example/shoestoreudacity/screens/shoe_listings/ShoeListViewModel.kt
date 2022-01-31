package com.example.shoestoreudacity.screens.shoe_listings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestoreudacity.models.Shoes

class ShoeListViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private var _shoesList = MutableLiveData<List<Shoes>>()
    val shoesList: LiveData<List<Shoes>> get() = _shoesList

    private var _selectedShoe = MutableLiveData<Shoes>()
    val selectedShoe: LiveData<Shoes> get() = _selectedShoe

    val shoe = Shoes("Jordans",12.5,"Addidas","Basketball", listOf("image1","image2"))

    fun getShoes(): LiveData<List<Shoes>> {
        return shoesList
    }
//    fun addShoeToList(shoe: String){
//        _selectedShoes.value =  shoe
//    }
}