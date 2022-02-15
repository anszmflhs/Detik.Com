package com.example.detikcom.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.detikcom.Adapter.AdapterCulinery
import com.example.detikcom.Model.ResponseNews
import com.example.detikcom.R
import com.example.detikcom.Service.RetrofitBuild
import com.example.detikcom.databinding.ActivityCulineryBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsCulineryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCulineryBinding
    private val culineryAdapter = AdapterCulinery()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCulineryBinding.inflate(layoutInflater)

        with(binding) {
            setContentView(binding.root)
//            setSupportActionBar(toolbarculinery)
            recyclerCulinery.adapter = culineryAdapter
            recyclerCulinery.layoutManager = LinearLayoutManager(baseContext)
            recyclerCulinery.setHasFixedSize(true)

            binding.fabNewsculinerys.setOnClickListener {
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, "Hey Check Out This A Great App")
                intent.type = "text/plain"
                startActivity(Intent.createChooser(intent, "Share To"))
            }
            val call = RetrofitBuild.getServiceCuliner().headlineculiner()
            call.enqueue(object : Callback<ResponseNews> {
                override fun onResponse(
                    call: Call<ResponseNews>,
                    response: Response<ResponseNews>
                ) {
                    val listCulineryItem = response.body()?.articles
                    listCulineryItem.let {
                        it?.let { it1 -> culineryAdapter.addDataCulinery(it1) }
                    }
                }

                override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                }
            })
        }
    }
}