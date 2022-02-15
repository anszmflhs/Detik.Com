package com.example.detikcom.Adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.number.Scale
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.detikcom.Model.ArticlesItem
import com.example.detikcom.activity.DetailNewsUkActivity
import com.example.detikcom.databinding.ItemRecyclerUkBinding

class AdapterNewsUk : RecyclerView.Adapter<AdapterNewsUk.ViewHolder>() {
    class ViewHolder(var binding: ItemRecyclerUkBinding) : RecyclerView.ViewHolder(binding.root)

        private var listnewsuk: ArrayList<ArticlesItem> = arrayListOf()

        @SuppressLint("NotifyDataSetChanged")
        fun addDataNewsUk(xrplgataungapa: List<ArticlesItem>){
            listnewsuk.clear()
            listnewsuk.addAll(xrplgataungapa)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclerUkBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataArticleberitaaa = listnewsuk[position]
        holder.binding.txtJuduluk.text = dataArticleberitaaa.title
        holder.binding.txtAuthoruk.text = dataArticleberitaaa.author
        holder.binding.txtPublisheduk.text = dataArticleberitaaa.publishedAt
        holder.binding.imageViewss.load(dataArticleberitaaa.urlToImage){
            scale(coil.size.Scale.FILL)
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context,DetailNewsUkActivity::class.java)
            intent.putExtra(DetailNewsUkActivity.TITLEUK,dataArticleberitaaa.title)
            intent.putExtra(DetailNewsUkActivity.DESCRIPTIONUK,dataArticleberitaaa.description)
            intent.putExtra(DetailNewsUkActivity.SOURCEUK,dataArticleberitaaa.source.toString())
            intent.putExtra(DetailNewsUkActivity.PUBLISHUK,dataArticleberitaaa.publishedAt)
            intent.putExtra(DetailNewsUkActivity.IMGUK,dataArticleberitaaa.urlToImage.toString())
            intent.putExtra(DetailNewsUkActivity.AUTHORUK,dataArticleberitaaa.author)
            intent.putExtra(DetailNewsUkActivity.CONTENTUK,dataArticleberitaaa.content)
            it.context.startActivity(intent)
        }
    }
    override fun getItemCount() = listnewsuk.size
    }