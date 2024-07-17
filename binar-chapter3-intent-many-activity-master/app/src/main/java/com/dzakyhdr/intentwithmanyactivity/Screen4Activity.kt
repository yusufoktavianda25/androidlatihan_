package com.dzakyhdr.intentwithmanyactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dzakyhdr.intentwithmanyactivity.databinding.ActivityScreen4Binding

class Screen4Activity : AppCompatActivity() {

    private lateinit var binding: ActivityScreen4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreen4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            sendName()
        }
    }

    private fun sendName() {
        val name = binding.edtName.text.toString()
        val usia = binding.edtUsia.text.toString().toInt()
        val alamat = binding.edtAlamat.text.toString()
        val pekerjaan = binding.edtPekerjaan.text.toString()

        val identity = Identity(name, usia, alamat, pekerjaan)
        val intent = Intent(this, Screen3Activity::class.java)
        intent.putExtra("identity", identity)
        startActivity(intent)
    }
}