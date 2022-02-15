package com.example.detikcom.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.detikcom.Model.ArticlesItem
import com.example.detikcom.activity.DetailCulineryActivity
import com.example.detikcom.activity.DetailSportActivity
import com.example.detikcom.databinding.ItemRecyclerCulineryBinding

class AdapterCulinery : RecyclerView.Adapter<AdapterCulinery.ViewHolder>() {
    class ViewHolder(var binding: ItemRecyclerCulineryBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var listculinery: ArrayList<ArticlesItem> = arrayListOf()

    fun addDataCulinery(xrplmulu: List<ArticlesItem>) {
        listculinery.clear()
        listculinery.addAll(xrplmulu)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRecyclerCulineryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataArticleCulinery = listculinery[position]
        holder.binding.txtJudulculinery.text = dataArticleCulinery.title
        holder.binding.txtAuthorculinery.text = dataArticleCulinery.author
        holder.binding.txtPublishedculinery.text = dataArticleCulinery.publishedAt
        holder.binding.imgCulinery.load(dataArticleCulinery.urlToImage) {
            scale(Scale.FILL)
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailCulineryActivity::class.java)
            intent.putExtra(DetailCulineryActivity.TITLE, dataArticleCulinery.title)
            intent.putExtra(DetailCulineryActivity.DESCRIPTION, dataArticleCulinery.description)
            intent.putExtra(DetailCulineryActivity.SOURCE, dataArticleCulinery.source.toString())
            intent.putExtra(DetailCulineryActivity.PUBLISHAT, dataArticleCulinery.publishedAt)
            intent.putExtra(DetailCulineryActivity.IMG, dataArticleCulinery.urlToImage.toString())
            intent.putExtra(DetailCulineryActivity.AUTHOR, dataArticleCulinery.author)
            intent.putExtra(DetailCulineryActivity.CONTENT, dataArticleCulinery.content)
            it.context.startActivity(intent)
        }
    }
    override fun getItemCount() = listculinery.size
}