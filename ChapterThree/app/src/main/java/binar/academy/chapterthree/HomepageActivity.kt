package binar.academy.chapterthree

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.academy.chapterthree.databinding.ActivityHomepageBinding

class HomepageActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomepageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.homepageButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}