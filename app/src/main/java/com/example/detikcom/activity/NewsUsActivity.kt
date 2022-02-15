package com.example.detikcom.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.detikcom.Adapter.AdapterNewsUs
import com.example.detikcom.Model.ResponseNews
import com.example.detikcom.R
import com.example.detikcom.Service.RetrofitBuild
import com.example.detikcom.databinding.ActivityNewsUsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsUsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsUsBinding
    private val newsAdapterus = AdapterNewsUs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_us)
        binding = ActivityNewsUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            setContentView(binding.root)
//            setSupportActionBar(toolbardesus)
            recyclernewus.adapter = newsAdapterus
            recyclernewus.layoutManager = LinearLayoutManager(baseContext)
            recyclernewus.setHasFixedSize(true)

            fabNewsuss.setOnClickListener {
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, "Hey Check Out This A Great App")
                intent.type = "text/plain"
                startActivity(Intent.createChooser(intent, "Share To"))
            }
            val calls = RetrofitBuild.getServiceUs().headlinesus()
            calls.enqueue(object : Callback<ResponseNews> {
                override fun onResponse(
                    call: Call<ResponseNews>,
                    response: Response<ResponseNews>
                ) {
                    val listartikelitems = response.body()?.articles
                    listartikelitems.let {
                        it?.let { it1 -> newsAdapterus.addDatanewss(it1) }
                    }
                }

                override fun onFailure(call: Call<ResponseNews>, t: Throwable) {

                }
            })
        }
    }
}