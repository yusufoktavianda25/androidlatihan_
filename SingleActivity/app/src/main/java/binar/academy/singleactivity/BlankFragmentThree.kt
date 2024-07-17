package binar.academy.singleactivity

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class BlankFragmentThree : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_three, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataTextView = view.findViewById<TextView>(R.id.thirdfragment_textview)
        val namaTextView = view.findViewById<TextView>(R.id.name_textview)
        val emailTextView = view.findViewById<TextView>(R.id.email_textview)
        val ageTextView = view.findViewById<TextView>(R.id.age_textview)
//        val dataFromFragmentTwo=arguments?.getString("key")
        val showName = arguments?.getString("name")
        val showEmail = arguments?.getString("email")
        val showAge = arguments?.getString("age")
        Log.d("fragmentthree",showName.toString())
        Log.d("fragmentthree",showEmail.toString())
        Log.d("fragmentthree",showAge.toString())
        //tampil data dari second

//        dataTextView.text = dataFromFragmentTwo
        namaTextView.setText(showName)
        emailTextView.setText(showEmail)
        ageTextView.setText(showAge)
    }

}