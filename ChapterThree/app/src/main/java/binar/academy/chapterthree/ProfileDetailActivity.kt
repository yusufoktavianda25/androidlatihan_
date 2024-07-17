package binar.academy.chapterthree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.academy.chapterthree.databinding.ActivityProfileDetailBinding


class ProfileDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityProfileDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}