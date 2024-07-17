package binar.academy.singleactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class BlankFragmentOne : Fragment() {
    private lateinit var navigateToSecondButton: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateToSecondButton = view.findViewById(R.id.blankfragmentone_button)
        navigateToSecondButton.setOnClickListener {

            navigateToFragmentTwo()
    //   Toast.makeText(requireActivity(), "hai",Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToFragmentTwo(){
        val fragmentManager: FragmentManager = parentFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        val blankFragmentTwo = BlankFragmentTwo()
        fragmentTransaction.replace(
            R.id.frame_layout_container,
            blankFragmentTwo,
            BlankFragmentTwo::class.java.simpleName
        )
        fragmentTransaction.addToBackStack("First Fragment")
            .commit()
    }
}