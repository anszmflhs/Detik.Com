package com.example.detikcom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.detikcom.Adapter.AdapterPropinsi
import com.example.detikcom.Model.ResponsePropinsi
import com.example.detikcom.R
import com.example.detikcom.Service.RetrofitBuild
import com.example.detikcom.databinding.ActivityPropinsiBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PropinsiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPropinsiBinding
    private val provinceAdapter = AdapterPropinsi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_propinsi)
        binding = ActivityPropinsiBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//        )

        binding.recyclerpropinsi.adapter = provinceAdapter
        binding.recyclerpropinsi.layoutManager = LinearLayoutManager(baseContext)
        binding.recyclerpropinsi.setHasFixedSize(true)

        val call = RetrofitBuild.getServicePropinsi().headlinescovidpropinsi()
        call.enqueue(object : Callback<ResponsePropinsi>{
            override fun onResponse(
                call: Call<ResponsePropinsi>,
                response: Response<ResponsePropinsi>
            ) {
                val listpropinsi = response.body()?.data
                listpropinsi.let {
                    it?.let { it1 -> provinceAdapter.addDataCovid(it1) }
                }
            }
            override fun onFailure(call: Call<ResponsePropinsi>, t: Throwable) {
            }

        })
    }
}