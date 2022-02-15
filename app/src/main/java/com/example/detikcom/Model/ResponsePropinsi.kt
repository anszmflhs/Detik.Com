package com.example.detikcom.Model

import com.google.gson.annotations.SerializedName

data class ResponsePropinsi(

	@field:SerializedName("data")
	val data: List<DataItem>? = null
)

data class DataItem(

	@field:SerializedName("fid")
	val fid: Int? = null,

	@field:SerializedName("provinsi")
	val provinsi: String? = null,

	@field:SerializedName("kasusMeni")
	val kasusMeni: String? = null,

	@field:SerializedName("kodeProvi")
	val kodeProvi: String? = null,

	@field:SerializedName("kasusSemb")
	val kasusSemb: String? = null,

	@field:SerializedName("kasusPosi")
	val kasusPosi: String? = null
)
