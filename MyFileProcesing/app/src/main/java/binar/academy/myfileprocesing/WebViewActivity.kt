package binar.academy.myfileprocesing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import binar.academy.myfileprocesing.databinding.ActivityWebViewBinding
import com.downloader.utils.Utils
import com.github.barteksc.pdfviewer.util.Util

class WebViewActivity : AppCompatActivity() {
    private lateinit var binding : ActivityWebViewBinding
    private lateinit var Utils : binar.academy.myfileprocesing.utils.Utils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            webView.webViewClient = WebViewClient()
            webView.settings.setSupportZoom(true)
            webView.settings.javaScriptEnabled = true
            val url = Utils.getPdfUrl()
            webView.loadUrl("https://docs.google.com/gview?embedded=true&url=$url")
        }
    }
}