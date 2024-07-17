package com.binar.ariefaryudisyidik.networkingsample.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.binar.ariefaryudisyidik.networkingsample.adapter.CarAdapter
import com.binar.ariefaryudisyidik.networkingsample.data.model.GetAllCarResponseItem
import com.binar.ariefaryudisyidik.networkingsample.data.network.CarsApi
import com.binar.ariefaryudisyidik.networkingsample.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchData()
    }

    private fun fetchData() {
        CarsApi.retrofitService.allCar().enqueue(object : Callback<List<GetAllCarResponseItem>> {
            override fun onResponse(
                call: Call<List<GetAllCarResponseItem>>,
                response: Response<List<GetAllCarResponseItem>>
            ) {
                val body = response.body()
                val code = response.code()
                if (code == 200) {
                    binding.pbLoading.isGone
                    body?.let { showList(it) }
                    Log.d("HomeFragment", response.message())
                } else {
                    binding.pbLoading.isGone
                }
            }

            override fun onFailure(call: Call<List<GetAllCarResponseItem>>, t: Throwable) {
                binding.pbLoading.isGone
                Log.e("Home Fragment", t.message.toString())
            }
        })
    }

    private fun showList(data: List<GetAllCarResponseItem>) {
        val adapter = CarAdapter(object : CarAdapter.OnClickListener {
            override fun onClickItem(data: GetAllCarResponseItem) {
                val carName = data.name
                val carPrice = data.price
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                        carName,
                        carPrice
                    )
                )
            }
        })
        adapter.submitData(data)
        binding.rvCar.layoutManager = LinearLayoutManager(context)
        binding.rvCar.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}