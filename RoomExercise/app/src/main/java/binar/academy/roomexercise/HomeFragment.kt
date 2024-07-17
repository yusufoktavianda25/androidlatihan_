package binar.academy.roomexercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import binar.academy.roomexercise.data.StudentAdapter
import binar.academy.roomexercise.data.database.StudentDatabase
import binar.academy.roomexercise.databinding.FragmentHomeBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

@DelicateCoroutinesApi
class HomeFragment : Fragment() {

    private var mDB : StudentDatabase? = null
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mDB= StudentDatabase.getInstance(view.context)
        binding.userRecycle.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        fetchData()
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addFragment)
        }

    }

    fun fetchData() {
        GlobalScope.async {
            val listStudent = mDB?.studentDao()?.getAllStudent()
            activity?.runOnUiThread{
                listStudent?.let {
                    val adapter = StudentAdapter(it)
                    binding.userRecycle.adapter = adapter
                }
            }
        }
    }

    override fun onResume() {
        fetchData()
        super.onResume()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        StudentDatabase.destroyInstance()
    }

}