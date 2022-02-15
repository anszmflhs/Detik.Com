package com.example.detikcom.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.detikcom.Adapter.AdapterWeekend
import com.example.detikcom.Model.ResponseNews
import com.example.detikcom.R
import com.example.detikcom.Service.RetrofitBuild
import com.example.detikcom.databinding.ActivityNewsWeekendBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsWeekendActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsWeekendBinding
    private val weekendAdapter = AdapterWeekend()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsWeekendBinding.inflate(layoutInflater)

        with(binding) {
            setContentView(binding.root)
//            setSupportActionBar(toolbarweekends)
            recyclerWeekend.adapter = weekendAdapter
            recyclerWeekend.layoutManager = LinearLayoutManager(baseContext)
            recyclerWeekend.setHasFixedSize(true)

            fabNewsweekends.setOnClickListener {
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, "Hey Check Out This A Great App")
                intent.type = "text/plain"
                startActivity(Intent.createChooser(intent, "Share To"))
            }
            val call = RetrofitBuild.getServiceWeekend().headlineweekend()
            call.enqueue(object : Callback<ResponseNews> {
                override fun onResponse(
                    call: Call<ResponseNews>,
                    response: Response<ResponseNews>
                ) {
                    val listartikelitemss = response.body()?.articles
                    listartikelitemss.let {
                        it?.let { it1 -> weekendAdapter.addDataWeekend(it1) }
                    }
                }

                override fun onFailure(call: Call<ResponseNews>, t: Throwable) {

                }

            })
        }
    }
}