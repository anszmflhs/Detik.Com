package com.example.detikcom.Service

import com.example.detikcom.Model.ResponseCovid
import com.example.detikcom.Model.ResponseNews
import com.example.detikcom.Model.ResponsePropinsi
import com.example.detikcom.activity.PropinsiActivity
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Headers

object RetrofitBuild {
    private val client: OkHttpClient = OkHttpClient.Builder().build()

    //mengkonfigurasi URL dasar atau baseurl
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun getServiceIndo() = retrofit.create(NewsTopIndo::class.java)
    fun getServiceUs() = retrofit.create(NewsTopUs::class.java)
    fun getServiceUk() = retrofit.create(NewsTopUk::class.java)
    fun getServiceSport() = retrofit.create(NewsTopSport::class.java)
    fun getServiceCuliner() = retrofit.create(NewsTopCuliner::class.java)
    fun getServiceWeekend() = retrofit.create(NewsTopWeekend::class.java)

    fun getServicePositive() = retrofit.create(JumlahPositive::class.java)
    fun getServiceSembuh() = retrofit.create(PasienSembuh::class.java)
    fun getServiceMati() = retrofit.create(PasienMati::class.java)
    fun getServicePropinsi() = retrofit.create(Propinsi::class.java)

}

interface NewsTopIndo {
    @Headers("Authorization: ba77e0e5b1f347d39087968673eb5fb7")
    @GET("v2/top-headlines?country=id")

    fun headlinesindo(): Call <ResponseNews>
}

interface NewsTopUs {
    @Headers("Authorization: ba77e0e5b1f347d39087968673eb5fb7")
    @GET("v2/top-headlines?country=us")

    fun headlinesus(): Call <ResponseNews>
}

interface NewsTopUk {
    @Headers("Authorization: ba77e0e5b1f347d39087968673eb5fb7")
    @GET("v2/top-headlines?country=gb")

    fun headlineuk(): Call <ResponseNews>
}
interface JumlahPositive {
    @GET("https://api.kawalcorona.com/positif/")

    fun headlinecovidpositif(): Call <ResponseCovid>
}
interface PasienSembuh {
    @GET("https://api.kawalcorona.com/sembuh/")

    fun headlinecovidsembuh(): Call <ResponseCovid>
}
interface PasienMati {
    @GET("https://api.kawalcorona.com/meninggal/")

    fun headlinecovidmati(): Call <ResponseCovid>
}
interface Propinsi {
    @GET("https://indonesia-covid-19.mathdro.id/")

    fun headlinescovidpropinsi(): Call<ResponsePropinsi>
}
interface NewsTopSport {
    @Headers("Authorization: ba77e0e5b1f347d39087968673eb5fb7")
    @GET("v2/top-headlines?country=id&category=sports")

    fun headlinesport(): Call<ResponseNews>
}
interface NewsTopCuliner {
    @Headers("Authorization: ba77e0e5b1f347d39087968673eb5fb7")
    @GET("v2/everything?q=food")

    fun headlineculiner(): Call<ResponseNews>
}
interface NewsTopWeekend {
    @Headers("Authorization: ba77e0e5b1f347d39087968673eb5fb7")
    @GET("v2/everything?q=weekend")

    fun headlineweekend(): Call<ResponseNews>
}