package com.example.detikcom.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.detikcom.Model.DataItem
import com.example.detikcom.Model.ResponsePropinsi
import com.example.detikcom.databinding.ItemRecyclerPropinsiBinding

class AdapterPropinsi : RecyclerView.Adapter<AdapterPropinsi.ViewHolder>() {
    class ViewHolder(var binding : ItemRecyclerPropinsiBinding) : RecyclerView.ViewHolder(binding.root)

    private var listPropinsi : ArrayList<DataItem> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun addDataCovid(xrpldesu: List<DataItem>){
        listPropinsi.clear()
        listPropinsi.addAll(xrpldesu)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclerPropinsiBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataCovid = listPropinsi[position]
        holder.binding.txtProvince.text = dataCovid.provinsi
        holder.binding.txtPositiveaowk.text = dataCovid.kasusPosi
        holder.binding.txtCuredaowk.text = dataCovid.kasusSemb
        holder.binding.txtMatisad.text = dataCovid.kasusMeni
//        holder.itemView.setOnClickListener {
//            val intent = Intent(it.context,PropinsiActivity::class.java)
//            intent.putExtra(PropinsiActivity.Province,dataCovid.provinsi)
//            intent.putExtra(PropinsiActivity.Positive,dataCovid.kasusPosi)
//            intent.putExtra(PropinsiActivity.Cured,dataCovid.kasusSemb)
//            intent.putExtra(PropinsiActivity.Dead,dataCovid.kasusMeni)
//            it.context.startActivity(intent)
        }
    override fun getItemCount() = listPropinsi.size
    }

//companion object{
//    const val Province = "A"
//    const val Positive = "S"
//    const val Cured = "D"
//    const val Dead = "F"
//}