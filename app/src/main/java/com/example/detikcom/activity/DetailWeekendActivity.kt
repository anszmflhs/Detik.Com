package com.example.detikcom.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.detikcom.R
import com.example.detikcom.databinding.ActivityDetailSportBinding
import com.example.detikcom.databinding.ActivityDetailWeekendBinding

class DetailWeekendActivity : AppCompatActivity() {
    companion object{
        const val TITLE = "Y"
        const val SOURCE = "N"
        const val PUBLISHAT = "P"
        const val IMG = "I"
        const val AUTHOR = "A"
        const val CONTENT = "C"
        const val DESCRIPTION = "D"
    }

    private lateinit var binding: ActivityDetailWeekendBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailWeekendBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtJuduldetailweekend.text = intent.getStringExtra(TITLE)
        binding.txtDeskdetailweekend.text = intent.getStringExtra(DESCRIPTION)
        binding.txtAuthorweekends.text = intent.getStringExtra(AUTHOR)
        binding.txtContentweekend.text = intent.getStringExtra(CONTENT)
        binding.txtPublishedweekends.text = intent.getStringExtra(PUBLISHAT)
        binding.imgDetailweekend.load(intent.getStringExtra(IMG))

        binding.fabNewsweekend.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"Hey Check Out This A Great App")
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Share To"))
        }
    }
}