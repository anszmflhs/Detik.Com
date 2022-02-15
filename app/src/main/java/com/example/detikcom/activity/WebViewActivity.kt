package com.example.detikcom.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.example.detikcom.R
import com.example.detikcom.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            webview.webViewClient = WebViewClient()

            webview.apply {
                loadUrl("https://kawalcorona.com/")

                settings.javaScriptEnabled = true
                settings.safeBrowsingEnabled = true
            }
        }
    }
}