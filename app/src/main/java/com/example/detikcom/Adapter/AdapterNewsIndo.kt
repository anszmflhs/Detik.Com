package com.example.detikcom.Adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.detikcom.Model.ArticlesItem
import com.example.detikcom.Model.ResponseNews
import com.example.detikcom.activity.DetailNewsIndo
import com.example.detikcom.databinding.ItemRecyclerIndoBinding

class AdapterNewsIndo : RecyclerView.Adapter<AdapterNewsIndo.ViewHolder>() {
    class ViewHolder(var binding: ItemRecyclerIndoBinding) : RecyclerView.ViewHolder(binding.root)

    private var listnews: ArrayList<ArticlesItem> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun addDataNews(xrplngambildata: List<ArticlesItem>){
        listnews.clear()
        listnews.addAll(xrplngambildata)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRecyclerIndoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataArticleberita = listnews[position]
        holder.binding.txtJudulindo.text = dataArticleberita.title
        holder.binding.txtAuthordetail.text = dataArticleberita.author
        holder.binding.txtPublished.text = dataArticleberita.publishedAt
        holder.binding.imageView.load(dataArticleberita.urlToImage) {
            scale(Scale.FILL)
        }
        holder.itemView.setOnClickListener{
            val intent = Intent(it.context,DetailNewsIndo::class.java)
            intent.putExtra(DetailNewsIndo.TITLE,dataArticleberita.title)
            intent.putExtra(DetailNewsIndo.SOURCE,dataArticleberita.source.toString())
            intent.putExtra(DetailNewsIndo.PUBLISHAT,dataArticleberita.publishedAt)
            intent.putExtra(DetailNewsIndo.IMG,dataArticleberita.urlToImage.toString())
            intent.putExtra(DetailNewsIndo.AUTHOR,dataArticleberita.author)
            intent.putExtra(DetailNewsIndo.CONTENT,dataArticleberita.content)
            intent.putExtra(DetailNewsIndo.DESCRIPTION,dataArticleberita.description)
            it.context.startActivity(intent)
        }
    }
    override fun getItemCount() = listnews.size
}