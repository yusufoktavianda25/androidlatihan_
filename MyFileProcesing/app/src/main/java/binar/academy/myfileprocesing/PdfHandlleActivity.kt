package binar.academy.myfileprocesing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.academy.myfileprocesing.databinding.ActivityPdfHandlleBinding

class PdfHandlleActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPdfHandlleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPdfHandlleBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}