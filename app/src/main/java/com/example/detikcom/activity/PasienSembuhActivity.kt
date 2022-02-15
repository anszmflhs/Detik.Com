package com.example.detikcom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.detikcom.Model.ResponseCovid
import com.example.detikcom.R
import com.example.detikcom.Service.RetrofitBuild
import com.example.detikcom.databinding.ActivityPasienSembuhBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PasienSembuhActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPasienSembuhBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasienSembuhBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val call = RetrofitBuild.getServiceSembuh().headlinecovidsembuh()
        call.enqueue(object : Callback<ResponseCovid> {
            override fun onResponse(
                call: Call<ResponseCovid>,
                response: Response<ResponseCovid>
            ) {
                val listsembuh = response.body()
                listsembuh.let {
                    binding.txtSembuh.text = listsembuh?.value
                }
            }

            override fun onFailure(call: Call<ResponseCovid>, t: Throwable) {

            }
        })
    }
}