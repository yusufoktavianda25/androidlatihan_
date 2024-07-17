package binar.academy.roomexercise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import binar.academy.roomexercise.data.Student
import binar.academy.roomexercise.data.database.StudentDatabase
import binar.academy.roomexercise.databinding.FragmentAddBinding
import binar.academy.roomexercise.databinding.FragmentHomeBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class AddFragment : Fragment() {
    var mDb: StudentDatabase? = null
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mDb = StudentDatabase.getInstance(requireContext())
        binding.btnSave.setOnClickListener {
            val objectStudent = Student(
                null,
                binding.etNamaStudent.text.toString(),
                binding.etEmailStudent.text.toString()
            )

            GlobalScope.launch {
                val result = mDb?.studentDao()?.insertStudent(objectStudent)
                activity?.runOnUiThread {
                    if(result != 0.toLong() ){
                        //sukses
                        Toast.makeText(requireContext(),"Sukses menambahkan ${objectStudent.name}",
                            Toast.LENGTH_LONG).show()
                    }else{
                        //gagal
                        Toast.makeText(requireContext(),"Gagal menambahkan ${objectStudent.name}",
                            Toast.LENGTH_LONG).show()
                    }
                }
            }
            findNavController().navigate(R.id.action_addFragment_to_homeFragment)
        }


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}