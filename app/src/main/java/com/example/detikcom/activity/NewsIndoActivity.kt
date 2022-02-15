package com.example.detikcom.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.detikcom.Adapter.AdapterNewsIndo
import com.example.detikcom.Model.ResponseNews
import com.example.detikcom.R
import com.example.detikcom.Service.RetrofitBuild
import com.example.detikcom.databinding.ActivityNewsIndoBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsIndoActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNewsIndoBinding
    private val newsadapter = AdapterNewsIndo()
    private var isLoading = false
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_indo)
        binding = ActivityNewsIndoBinding.inflate(layoutInflater)

        with(binding){
            setContentView(binding.root)
//            setSupportActionBar(toolbardesu)
            recyclernewsindo.adapter = newsadapter
            recyclernewsindo.layoutManager = LinearLayoutManager(baseContext)
            recyclernewsindo.setHasFixedSize(true)

            fabNewsindos.setOnClickListener {
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT,"Hey Check Out This A Great App")
                intent.type="text/plain"
                startActivity(Intent.createChooser(intent,"Share To"))
            }
        }
        val call = RetrofitBuild.getServiceIndo().headlinesindo()
//call enque untuk mengambil data dari internet
        call.enqueue(object : Callback<ResponseNews>{
            override fun onResponse(
                call: Call<ResponseNews>,
                response: Response<ResponseNews>
            ) {
                val listartikelitem = response.body()?.articles
                listartikelitem.let {
                    it?.let { it1 -> newsadapter.addDataNews(it1) }
                }
            }
            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {

            }
        })
    }
}