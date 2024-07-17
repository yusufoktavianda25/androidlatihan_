package binar.academy.challengesixth.features.splashscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import binar.academy.challengesixth.R
import binar.academy.challengesixth.databinding.FragmentSplashScreenBinding

class SplashScreen : Fragment() {
    private var _binding : FragmentSplashScreenBinding?=null
    private val binding get()= _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSplashScreenBinding.inflate(inflater,container,false)
        return binding?.root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}