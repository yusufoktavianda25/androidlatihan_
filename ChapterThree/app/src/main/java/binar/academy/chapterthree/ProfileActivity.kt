package binar.academy.chapterthree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import binar.academy.chapterthree.databinding.ActivityProfileBinding


class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private var age = " "
    private var status = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val name_profile = intent.getStringExtra("name_profile")
        val name_profile = intent.getParcelableExtra<Identity>("name_profile")
        val identity = intent.getParcelableExtra<Identity>("identity")
        Log.d("ProfileActivity", name_profile.toString())
        Log.d("ProfileActivity", identity.toString())
        if (name_profile != null) {
//            binding.nameProfile.text = name_profile
            viewIdentitypassing(name_profile)
        } else if (identity != null) {
            viewIdentity(identity)
        }
        binding.profileButton.setOnClickListener {
            val intent = Intent(this, RegisterDataActivity::class.java)
            startActivity(intent)
        }
    }
    fun viewIdentitypassing(identitypassing: Identity) {
          binding.nameProfile.text = identitypassing.name
    }

    fun viewIdentity(identity: Identity) {
//        with(binding){
//            nameProfile.visibility = View.INVISIBLE
//            viewDetailProfile.detailProfileLayout.visibility = View.VISIBLE
//            viewDetailProfile.txtFullname.text = identity.name
//            viewDetailProfile.txtAlamat.text = identity.address
//            viewDetailProfile.txtPekerjaan.text = identity.job
//        }
        binding.nameProfile.visibility = View.INVISIBLE
        binding.viewDetailProfile.detailProfileLayout.visibility = View.VISIBLE
        binding.viewDetailProfile.txtFullname.text = identity.name
        binding.viewDetailProfile.txtAlamat.text = identity.address
        binding.viewDetailProfile.txtPekerjaan.text = identity.job
        if (identity.age % 2 == 0) {
            status = "Genap"
//            age = getString(R.string.umur, identity.age,  status)
            age = getString(R.string.umur, identity.age,  status)
        } else {
            status = "Ganjil"
            age = getString(R.string.umur, identity.age, status)
        }
        binding.viewDetailProfile.txtAge.text = age
        Log.d("infostatus",status)
    }
}