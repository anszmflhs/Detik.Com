package com.example.detikcom.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.detikcom.R
import com.example.detikcom.databinding.ActivityCulineryBinding
import com.example.detikcom.databinding.ActivityDetailCulineryBinding
import com.example.detikcom.databinding.ActivityDetailSportBinding

class DetailCulineryActivity : AppCompatActivity() {
    companion object{
        const val TITLE = "Y"
        const val SOURCE = "N"
        const val PUBLISHAT = "P"
        const val IMG = "I"
        const val AUTHOR = "A"
        const val CONTENT = "C"
        const val DESCRIPTION = "D"
    }

    private lateinit var binding: ActivityDetailCulineryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCulineryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtJuduldetailculinerys.text = intent.getStringExtra(TITLE)
        binding.txtDeskdetailculinerys.text = intent.getStringExtra(DESCRIPTION)
        binding.txtAuthorculinerys.text = intent.getStringExtra(AUTHOR)
        binding.txtContentculinerys.text = intent.getStringExtra(CONTENT)
        binding.txtPublishedculinerys.text = intent.getStringExtra(PUBLISHAT)
        binding.imgDetailculinerys.load(intent.getStringExtra(IMG))

        binding.fabNewsculinery.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"Hey Check Out This A Great App")
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Share To"))
        }
    }
}