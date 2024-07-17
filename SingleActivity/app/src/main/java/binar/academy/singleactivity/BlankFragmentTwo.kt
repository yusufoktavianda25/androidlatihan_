package binar.academy.singleactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class BlankFragmentTwo : Fragment() {
    private lateinit var navigateToThirdFragment: Button
    private lateinit var nameFragmentThree: EditText
    private lateinit var emailFragmentThree: EditText
    private lateinit var ageFragmentThree: EditText


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateToThirdFragment = view.findViewById(R.id.fragmenttwo_button)
        nameFragmentThree = view.findViewById(R.id.name_editText)
        emailFragmentThree = view.findViewById(R.id.email_editText)
        ageFragmentThree = view.findViewById(R.id.age_editText)

        navigateToThirdFragment.setOnClickListener {
            val fragmentManager: FragmentManager = parentFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            val blankFragmentThree = BlankFragmentThree()
            val bundle = Bundle()
            val nameEdit = view.findViewById<EditText>(R.id.name_editText).text.toString()
            val emailEdit = view.findViewById<EditText>(R.id.email_editText).text.toString()
            val ageEdit = view.findViewById<EditText>(R.id.age_editText).text.toString()
//            bundle.putString("key", "ini data dari second fragment")
            bundle.putString("name", nameEdit.toString())
            bundle.putString("email", emailEdit.toString())
            bundle.putString("age", ageEdit.toString())

            blankFragmentThree.arguments = bundle
            fragmentTransaction.replace(
                R.id.frame_layout_container,
                blankFragmentThree,
                BlankFragmentThree::class.java.simpleName
            )
            fragmentTransaction.addToBackStack(null)
                .commit()
        }
    }
}
/**
 * Secnd fragment buat 3 inputan dimana ada nama,email,umur
 */