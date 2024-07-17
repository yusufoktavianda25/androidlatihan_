package com.dzakyhdr.intentwithmanyactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dzakyhdr.intentwithmanyactivity.databinding.Screen1MainBinding

class Screen1Activity : AppCompatActivity() {

    private lateinit var binding: Screen1MainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Screen1MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnScreen1.setOnClickListener {
            val intent = Intent(this, Screen2Activity::class.java)
            startActivity(intent)
        }

    }
}