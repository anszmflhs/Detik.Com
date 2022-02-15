package com.example.detikcom.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.detikcom.R
import com.example.detikcom.databinding.ActivityDetailNewsUkBinding

class DetailNewsUkActivity : AppCompatActivity() {

    companion object{
        const val TITLEUK = "Z"
        const val SOURCEUK = "X"
        const val PUBLISHUK = "C"
        const val IMGUK = "V"
        const val AUTHORUK = "B"
        const val CONTENTUK = "N"
        const val DESCRIPTIONUK = "M"
    }

    private lateinit var binding: ActivityDetailNewsUkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNewsUkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtJuduldetailuk.text = intent.getStringExtra(TITLEUK)
        binding.txtPublisheduks.text = intent.getStringExtra(PUBLISHUK)
        binding.imgDetailuk.load(intent.getStringExtra(IMGUK))
        binding.txtAuthoruks.text = intent.getStringExtra(AUTHORUK)
        binding.txtDeskdetailuk.text = intent.getStringExtra(DESCRIPTIONUK)
        binding.txtContentuk.text = intent.getStringExtra(CONTENTUK)

        binding.fabNewsuk.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"Hey Check Out This A Great App")
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Share To"))
        }
    }
}