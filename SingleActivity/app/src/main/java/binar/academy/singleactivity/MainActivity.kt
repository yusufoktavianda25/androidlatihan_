package binar.academy.singleactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openBlankFirstFragment()
    }

    private fun openBlankFirstFragment() {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        val blankFragmentOne = BlankFragmentOne()
        fragmentTransaction.add(
            R.id.frame_layout_container,
            blankFragmentOne,
            BlankFragmentOne::class.java.simpleName
        )
        fragmentTransaction.commit()
    }
}