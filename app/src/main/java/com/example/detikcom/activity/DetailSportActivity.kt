package com.example.detikcom.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.detikcom.R
import com.example.detikcom.databinding.ActivityDetailSportBinding
import com.example.detikcom.databinding.ActivitySportBinding

class DetailSportActivity : AppCompatActivity() {
    companion object{
        const val TITLE = "Y"
        const val SOURCE = "N"
        const val PUBLISHAT = "P"
        const val IMG = "I"
        const val AUTHOR = "A"
        const val CONTENT = "C"
        const val DESCRIPTION = "D"
    }

    private lateinit var binding: ActivityDetailSportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtJuduldetailsport.text = intent.getStringExtra(TITLE)
        binding.txtDeskdetailsport.text = intent.getStringExtra(DESCRIPTION)
        binding.txtAuthorsport.text = intent.getStringExtra(AUTHOR)
        binding.txtContentsport.text = intent.getStringExtra(CONTENT)
        binding.txtPublishedsport.text = intent.getStringExtra(PUBLISHAT)
        binding.imgDetailsport.load(intent.getStringExtra(IMG))

        binding.fabNewssport.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"Hey Check Out This A Great App")
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Share To"))
        }
    }
}