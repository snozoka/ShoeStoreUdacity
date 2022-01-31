package com.example.shoestoreudacity.screens.instructions

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.shoestoreudacity.R
import com.example.shoestoreudacity.databinding.InstructionFragmentBinding

class InstructionFragment : Fragment() {

    companion object {
        fun newInstance() = InstructionFragment()
    }

    private lateinit var viewModel: InstructionViewModel
    private lateinit var _binding: InstructionFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater,R.layout.instruction_fragment, container, false)
        _binding.buttonToShoeList.setOnClickListener{view: View ->
            Navigation.findNavController(view).navigate(R.id.action_instructionFragment_to_shoeListFragment)
        }
        return _binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InstructionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}