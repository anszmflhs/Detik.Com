package com.example.detikcom.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.detikcom.Adapter.AdapterNewsUk
import com.example.detikcom.Adapter.AdapterNewsUs
import com.example.detikcom.Model.ResponseNews
import com.example.detikcom.R
import com.example.detikcom.Service.RetrofitBuild
import com.example.detikcom.databinding.ActivityNewsUkBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsUkActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsUkBinding
    private val newsAdapterUk = AdapterNewsUk()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_uk)
        binding = ActivityNewsUkBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            setContentView(binding.root)
//            setSupportActionBar(toolbardesuk)
            recyclernewuk.adapter = newsAdapterUk
            recyclernewuk.layoutManager = LinearLayoutManager(baseContext)
            recyclernewuk.setHasFixedSize(true)

            fabNewsuks.setOnClickListener {
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, "Hey Check Out This A Great App")
                intent.type = "text/plain"
                startActivity(Intent.createChooser(intent, "Share To"))
            }
            val callss = RetrofitBuild.getServiceUk().headlineuk()
            callss.enqueue(object : Callback<ResponseNews> {
                override fun onResponse(
                    call: Call<ResponseNews>,
                    response: Response<ResponseNews>
                ) {
                    val listartikelitemss = response.body()?.articles
                    listartikelitemss.let {
                        it?.let { it1 -> newsAdapterUk.addDataNewsUk(it1) }
                    }
                }

                override fun onFailure(call: Call<ResponseNews>, t: Throwable) {

                }
            })
        }
    }
}