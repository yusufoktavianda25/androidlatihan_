package com.example.movietmdbchallenge.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.listmoview.room.User
import com.example.movietmdbchallenge.R
import com.example.movietmdbchallenge.databinding.FragmentRegisterBinding
import com.example.movietmdbchallenge.ui.ViewModelFactory
import com.example.movietmdbchallenge.ui.home.UserViewModel


class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
//    private val viewModel : UserViewModel by activityViewModels()
    lateinit var registerViewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = ViewModelFactory(view.context)
        registerViewModel=ViewModelProvider(requireActivity(),factory)[RegisterViewModel::class.java]



        binding.signUpButton.setOnClickListener {
            val user = User(
                email    = binding.inputEmailEditText.text.toString(),
                password = binding.inputPasswordEditText.text.toString(),
                username = binding.inputUsernameEditText.text.toString()
            )
            registerViewModel.register(user,binding.inputConfirmPasswordEditText.text.toString())
        }
        registerViewModel.getCekValidRegister().observe(viewLifecycleOwner){
            if(it == true){
                findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
                registerViewModel.reset()
            }
        }

    }

}