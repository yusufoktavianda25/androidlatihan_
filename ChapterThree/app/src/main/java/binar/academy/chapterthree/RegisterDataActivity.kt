package binar.academy.chapterthree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import binar.academy.chapterthree.databinding.ActivityRegisterDataBinding


class RegisterDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            sendName()
        }
    }
    private fun sendName() {
        val identitygetname = intent.getParcelableExtra<Identity>("identity")
        val name = nameregister
        Log.d("RegisterData", name.toString())
//        val name = binding.edtName.text.toString()
        val usia = binding.edtUsia.text.toString().toInt()
        val alamat = binding.edtAlamat.text.toString()
        val pekerjaan = binding.edtPekerjaan.text.toString()
        val identity = Identity(name, usia, alamat, pekerjaan)
        val intent = Intent(this, ProfileActivity::class.java)
        intent.putExtra("identity", identity)
        startActivity(intent)
    }
}