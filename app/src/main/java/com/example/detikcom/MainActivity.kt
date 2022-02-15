package com.example.detikcom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.detikcom.Adapter.AdapterNewsIndo
import com.example.detikcom.Model.ResponseNews
import com.example.detikcom.activity.*
import com.example.detikcom.databinding.ActivityMainBinding
import com.example.detikcom.databinding.ActivityNewsIndoBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//        )

        binding.linearindo.setOnClickListener {
                startActivity(Intent(this,NewsIndoActivity::class.java))
        }
        binding.linearus.setOnClickListener {
            startActivity(Intent(this,NewsUsActivity::class.java))
        }
        binding.linearuk.setOnClickListener {
            startActivity(Intent(this,NewsUkActivity::class.java))
        }
        binding.cardCovid.setOnClickListener {
            startActivity(Intent(this,PositiveCovidActivity::class.java))
        }
        binding.cardSembuh.setOnClickListener {
            startActivity(Intent(this,PasienSembuhActivity::class.java))
        }
        binding.cardMati.setOnClickListener {
            startActivity(Intent(this,PasienMatiActivity::class.java))
        }
        binding.cardProvince.setOnClickListener {
            startActivity(Intent(this,PropinsiActivity::class.java))
        }
        binding.cardSport.setOnClickListener {
            startActivity(Intent(this,NewsSportActivity::class.java))
        }
        binding.linkcorona.setOnClickListener {
            startActivity(Intent(this,WebViewActivity::class.java))
        }
        binding.cardCulinary.setOnClickListener {
            startActivity(Intent(this,NewsCulineryActivity::class.java))
        }
        binding.cardWeekend.setOnClickListener {
            startActivity(Intent(this,NewsWeekendActivity::class.java))
        }
    }
}