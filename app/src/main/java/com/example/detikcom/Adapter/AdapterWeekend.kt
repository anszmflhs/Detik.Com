package com.example.detikcom.Adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.detikcom.Model.ArticlesItem
import com.example.detikcom.activity.DetailSportActivity
import com.example.detikcom.activity.DetailWeekendActivity
import com.example.detikcom.databinding.ItemRecyclerSportBinding
import com.example.detikcom.databinding.ItemRecyclerWeekendBinding

class AdapterWeekend : RecyclerView.Adapter<AdapterWeekend.ViewHolder>() {
    class ViewHolder(var binding: ItemRecyclerWeekendBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var listweekend: ArrayList<ArticlesItem> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun addDataWeekend(xrplndess: List<ArticlesItem>) {
        listweekend.clear()
        listweekend.addAll(xrplndess)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRecyclerWeekendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataArticleWeekend = listweekend[position]
        holder.binding.txtJudulweekend.text = dataArticleWeekend.title
        holder.binding.txtAuthorweekend.text = dataArticleWeekend.author
        holder.binding.txtPublishedweekend.text = dataArticleWeekend.publishedAt
        holder.binding.imgSport.load(dataArticleWeekend.urlToImage) {
            scale(Scale.FILL)
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailWeekendActivity::class.java)
            intent.putExtra(DetailWeekendActivity.TITLE, dataArticleWeekend.title)
            intent.putExtra(DetailWeekendActivity.DESCRIPTION, dataArticleWeekend.description)
            intent.putExtra(DetailWeekendActivity.SOURCE, dataArticleWeekend.source.toString())
            intent.putExtra(DetailWeekendActivity.PUBLISHAT, dataArticleWeekend.publishedAt)
            intent.putExtra(DetailWeekendActivity.IMG, dataArticleWeekend.urlToImage.toString())
            intent.putExtra(DetailWeekendActivity.AUTHOR, dataArticleWeekend.author)
            intent.putExtra(DetailWeekendActivity.CONTENT, dataArticleWeekend.content)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = listweekend.size
}