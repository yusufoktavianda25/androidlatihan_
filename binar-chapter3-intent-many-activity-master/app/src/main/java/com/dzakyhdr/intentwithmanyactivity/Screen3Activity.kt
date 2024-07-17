package com.dzakyhdr.intentwithmanyactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.dzakyhdr.intentwithmanyactivity.databinding.ActivityScreen3Binding

class Screen3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityScreen3Binding
    private var status = ""
    private var usia = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreen3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val identity = intent.getParcelableExtra<Identity>("identity")

        if (name != null) {
            binding.txtYourname.text = name
        } else if (identity != null) {
            viewIdentity(identity)
        }

        binding.btnScreen3.setOnClickListener {
            val intent = Intent(this, Screen4Activity::class.java)
            startActivity(intent)
        }

    }

    fun viewIdentity(identity: Identity) {
        binding.txtYourname.visibility = View.INVISIBLE
        binding.viewDetail4.detail4.visibility = View.VISIBLE
        binding.viewDetail4.txtFullname.text = identity.name
        binding.viewDetail4.txtAlamat.text = identity.alamat
        binding.viewDetail4.txtPekerjaan.text = identity.pekerjaan
        binding.viewDetail4.txtAge.text = identity.usia.toString()

        if (identity.usia % 2 == 0) {
            status = "Genap"
            usia = getString(R.string.umur, identity.usia, status)
        } else {
            status = "Ganjil"
            usia = getString(R.string.umur, identity.usia, status)
        }
    }
}