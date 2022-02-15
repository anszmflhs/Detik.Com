package com.example.detikcom.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.detikcom.R
import com.example.detikcom.databinding.ActivityDetailNewsIndoBinding
import com.example.detikcom.databinding.ActivityDetailNewsUsBinding
import com.example.detikcom.databinding.ActivityNewsUsBinding

class DetailNewsUsActivity : AppCompatActivity() {
    companion object{
        const val TITLES = "Q"
        const val SOURCES = "W"
        const val PUBLISHEDATS = "E"
        const val IMGUS = "R"
        const val AUTHORS = "T"
        const val CONTENTS = "Y"
        const val DESCRIPTIONS = "U"
    }

    private lateinit var binding: ActivityDetailNewsUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNewsUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtJuduldetailus.text = intent.getStringExtra(TITLES)
        binding.txtPublishedus.text = intent.getStringExtra(PUBLISHEDATS)
        binding.imgDetailus.load(intent.getStringExtra(IMGUS))
        binding.txtAuthorus.text = intent.getStringExtra(AUTHORS)
        binding.txtDeskdetailus.text = intent.getStringExtra(DESCRIPTIONS)
        binding.txtContentus.text = intent.getStringExtra(CONTENTS)

        binding.fabNewsus.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"Hey Check Out This A Great App")
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Share To"))
        }
    }
}