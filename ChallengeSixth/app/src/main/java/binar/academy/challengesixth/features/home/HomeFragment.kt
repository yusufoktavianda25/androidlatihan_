package binar.academy.challengesixth.features.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import binar.academy.challengesixth.databinding.FragmentHomeBinding
import binar.academy.challengesixth.features.home.datasource.Status
import binar.academy.challengesixth.features.home.viewmodel.MainViewModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding?=null
    private val binding get() = _binding
    private lateinit var viewModel : MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }


    private fun setupView(){
        viewModel.getAllMoviesData().observe(viewLifecycleOwner){
            when(it.status){
                Status.SUCCESS->{
                    showList(resources.data)
                }
            }

        }

    }

    private fun showList(data: Any) {

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}