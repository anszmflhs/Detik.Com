package com.example.detikcom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.detikcom.Model.ResponseCovid
import com.example.detikcom.R
import com.example.detikcom.Service.RetrofitBuild
import com.example.detikcom.databinding.ActivityPasienMatiBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PasienMatiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPasienMatiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasienMatiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val call = RetrofitBuild.getServiceMati().headlinecovidmati()
        call.enqueue(object : Callback<ResponseCovid> {
            override fun onResponse(
                call: Call<ResponseCovid>,
                response: Response<ResponseCovid>
            ) {
                val listmati = response.body()
                listmati.let {
                    binding.txtMati.text = listmati?.value
                }
            }

            override fun onFailure(call: Call<ResponseCovid>, t: Throwable) {

            }
        })
    }
}