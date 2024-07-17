package com.binar.ariefaryudisyidik.challengegoldchapter6.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.binar.ariefaryudisyidik.challengegoldchapter6.R
import com.binar.ariefaryudisyidik.challengegoldchapter6.databinding.FragmentLoginBinding
import com.binar.ariefaryudisyidik.challengegoldchapter6.helper.UserDataStoreManager
import com.binar.ariefaryudisyidik.challengegoldchapter6.helper.UserPreferences
import com.binar.ariefaryudisyidik.challengegoldchapter6.viewmodel.UserRepositoryViewModel
import com.binar.ariefaryudisyidik.challengegoldchapter6.viewmodel.UserViewModel
import com.binar.ariefaryudisyidik.challengegoldchapter6.viewmodel.ViewModelFactory

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var userPreferences: UserPreferences
    private lateinit var viewModel: UserViewModel
    private lateinit var pref: UserDataStoreManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = UserDataStoreManager(requireContext())
        viewModel = ViewModelProvider(this, ViewModelFactory(pref))[UserViewModel::class.java]

        userPreferences = UserPreferences(requireContext())
        if (userPreferences.getLoggedInStatus()) {
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }

//        viewModel.getLoginStatus().observe(viewLifecycleOwner) { isLogin ->
//            if (isLogin) {
//                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
//            }
//        }

        setupView()
    }

    private fun setupView() {
        binding.apply {
            btnLogin.setOnClickListener {
                login()
            }
            tvRegister.setOnClickListener {
                register()
            }
        }
    }

    private fun login() {
        binding.apply {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(
                    requireContext(), "Field cannot be empty",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val userRepositoryViewModel by viewModels<UserRepositoryViewModel>()
                val user = userRepositoryViewModel.checkUser(email, password)

                if (user == null) {
                    Toast.makeText(
                        requireContext(),
                        "Incorrect email or password",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    viewModel.saveUser(user.id, true)
                    userPreferences.setLoggedInStatus(true)
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                }
            }
        }
    }

    private fun register() {
        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}