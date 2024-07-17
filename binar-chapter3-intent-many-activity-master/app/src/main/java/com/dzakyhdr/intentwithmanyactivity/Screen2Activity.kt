package com.dzakyhdr.intentwithmanyactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dzakyhdr.intentwithmanyactivity.databinding.ActivityScreen2Binding
import java.util.*

class Screen2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityScreen2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreen2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {

            val name = binding.edtName.text.toString().lowercase(Locale.getDefault())
            val intent = Intent(this, Screen3Activity::class.java)
            intent.putExtra("name", name)
            startActivity(intent)

        }
    }
}