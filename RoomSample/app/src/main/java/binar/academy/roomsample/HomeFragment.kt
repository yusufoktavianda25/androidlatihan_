package binar.academy.roomsample

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import binar.academy.roomsample.data.StudentAdapter
import binar.academy.roomsample.data.database.StudentDatabase
import binar.academy.roomsample.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var mDB : StudentDatabase? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mDB = StudentDatabase.getInstance(requireContext())
        fetchData()
        binding.fab.setOnClickListener {
            val add = Intent(requireContext(), AddFragment::class.java)
            startActivity(add)
        }
//        ini lanjutin
    }

    private fun fetchData() {
        CoroutineScope(Dispatchers.IO).launch {
            val listStudent = mDB?.studentDao()?.getAllStudent()
          activity?.runOnUiThread{
              listStudent?.let {
                  val adapter = StudentAdapter(it)
                  binding.userRecyclerView.adapter = adapter
              }
          }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}