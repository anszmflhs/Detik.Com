package com.example.detikcom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.detikcom.Model.ResponseCovid
import com.example.detikcom.Service.RetrofitBuild
import com.example.detikcom.databinding.ActivityPositiveCovidBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PositiveCovidActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPositiveCovidBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPositiveCovidBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val call = RetrofitBuild.getServicePositive().headlinecovidpositif()
        call.enqueue(object : Callback<ResponseCovid> {
            override fun onResponse(
                call: Call<ResponseCovid>,
                response: Response<ResponseCovid>
            ) {
                val listcovid = response.body()
                listcovid.let {
                    binding.txtPositive.text = listcovid?.value
                }
            }

            override fun onFailure(call: Call<ResponseCovid>, t: Throwable) {
            }
        })

    }
}