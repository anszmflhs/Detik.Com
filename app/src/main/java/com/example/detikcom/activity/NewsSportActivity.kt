package com.example.detikcom.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.detikcom.Adapter.AdapterSport
import com.example.detikcom.Model.ResponseNews
import com.example.detikcom.R
import com.example.detikcom.Service.RetrofitBuild
import com.example.detikcom.databinding.ActivityDetailSportBinding
import com.example.detikcom.databinding.ActivitySportBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsSportActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySportBinding
    private val sportAdapter = AdapterSport()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySportBinding.inflate(layoutInflater)

        with(binding) {
            setContentView(binding.root)
//            setSupportActionBar(toolbarsport)
            recyclerSport.adapter = sportAdapter
            recyclerSport.layoutManager = LinearLayoutManager(baseContext)
            recyclerSport.setHasFixedSize(true)

            binding.fabNewssports.setOnClickListener {
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT,"Hey Check Out This A Great App")
                intent.type="text/plain"
                startActivity(Intent.createChooser(intent,"Share To"))
            }
        }
        val call = RetrofitBuild.getServiceSport().headlinesport()
        call.enqueue(object : Callback<ResponseNews> {
            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
                val listSportItem = response.body()?.articles
                listSportItem.let {
                    it?.let { it1 -> sportAdapter.addDataSport(it1) }
                }
            }
            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
            }
        })
    }
}