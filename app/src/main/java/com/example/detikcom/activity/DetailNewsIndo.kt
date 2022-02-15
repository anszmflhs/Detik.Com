package com.example.detikcom.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.detikcom.R
import com.example.detikcom.databinding.ActivityDetailNewsIndoBinding
import com.example.detikcom.databinding.ActivityNewsIndoBinding

class DetailNewsIndo : AppCompatActivity() {

    companion object{
        const val TITLE = "Y"
        const val SOURCE = "N"
        const val PUBLISHAT = "P"
        const val IMG = "I"
        const val AUTHOR = "A"
        const val CONTENT = "C"
        const val DESCRIPTION = "D"
    }

    private lateinit var binding: ActivityDetailNewsIndoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNewsIndoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtJuduldetailindo.text = intent.getStringExtra(TITLE)
        binding.txtPublishedindo.text = intent.getStringExtra(PUBLISHAT)
        binding.imgDetailindo.load(intent.getStringExtra(IMG))
        binding.txtAuthorindo.text = intent.getStringExtra(AUTHOR)
        binding.txtDeskdetailindo.text = intent.getStringExtra(DESCRIPTION)
        binding.txtContentindo.text = intent.getStringExtra(CONTENT)

        binding.fabNewsindo.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"Hey Check Out This A Great App")
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Share To"))
        }

    }
}