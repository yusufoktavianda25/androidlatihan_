package binar.academy.mycatalogmovies.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import binar.academy.mycatalogmovies.R
import binar.academy.mycatalogmovies.data.remote.response.Movie
import binar.academy.mycatalogmovies.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.getUserId().observe(viewLifecycleOwner) {
//            viewModel.setUserId(it)
//        }

        viewModel.userData.observe(viewLifecycleOwner) { user ->
            if (user != null) {
                binding.tvUsername.text = "Welcome, ${user.username}!"
            }
        }

        viewModel.movie.observe(viewLifecycleOwner) { setMovieData(it) }

        viewModel.isLoading.observe(viewLifecycleOwner) { showLoading(it) }

        binding.ibProfile.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setMovieData(movie: List<Movie>) {
        binding.apply {
            val homeAdapter = HomeAdapter(movie)
            rvMovies.setHasFixedSize(true)
            rvMovies.layoutManager = LinearLayoutManager(activity)
            rvMovies.adapter = homeAdapter
            homeAdapter.setOnItemClickCallback(object :
                HomeAdapter.OnItemClickCallback {
                override fun onItemClicked(data: Movie) {
                    findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                            data
                        )
                    )
                }
            })
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}