package com.example.shoestoreudacity.screens.shoe_listings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestoreudacity.models.Shoes

class SharedShoeViewModel : ViewModel() {

    private var _shoesList = MutableLiveData<List<Shoes>>()
    val shoesListLiveData: LiveData<List<Shoes>> get() = _shoesList

    private var shoesList = mutableListOf<Shoes>()
    init {
        _shoesList.value = shoesList
    }

    val jordanShoe = Shoes("Jordans",12.5,
        "Nike","Basketball", listOf("image1","image2"))
    val addidasShoe = Shoes("Addidas Flight",13.5,
        "Addidas","Basketball", listOf("image1","image2"))
    val pumaShoe = Shoes("Puma Strive",10.5,
        "Puma","Basketball", listOf("image1","image2"))
    val asisShoe = Shoes("Asis run",15.5,
        "Asis","Running", listOf("image1","image2"))
    val reebokShoe = Shoes("Reebok Climb",9.5,
        "Reebok","Climbing", listOf("image1","image2"))
    val fubuShoe = Shoes("Fubu Black",10.5,
        "Fubu","Basketball", listOf("image1","image2"))


    fun addShoe(shoe: Shoes) {
        shoesList.add(shoe)
    }
}