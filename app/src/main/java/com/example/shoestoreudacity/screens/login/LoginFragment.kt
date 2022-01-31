package com.example.shoestoreudacity.screens.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.shoestoreudacity.R
import com.example.shoestoreudacity.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel
    private lateinit var _binding: LoginFragmentBinding
    val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater,R.layout.login_fragment,container,false)
        _binding.buttonLogin.setOnClickListener{view: View ->
            Navigation.findNavController(view).navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }
        _binding.buttonSignUp.setOnClickListener{view: View ->
            Navigation.findNavController(view).navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }
        return _binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel
    }

}