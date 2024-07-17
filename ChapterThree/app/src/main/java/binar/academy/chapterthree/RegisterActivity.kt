package binar.academy.chapterthree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.academy.chapterthree.databinding.ActivityRegisterBinding
lateinit var nameregister:String
class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.registerButton.setOnClickListener {
//            val nameregister = binding.nameRegisterEdittext.text.toString()
            nameregister = binding.nameRegisterEdittext.text.toString()
            val identity = Identity(nameregister,0, "","")
            val intent= Intent(this, ProfileActivity::class.java)
            intent.putExtra("name_profile", identity)
            startActivity(intent)

        }

    }
}