package com.example.detikcom.Adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.detikcom.Model.ArticlesItem
import com.example.detikcom.activity.DetailNewsUsActivity
import com.example.detikcom.databinding.ItemRecyclerUsBinding

class AdapterNewsUs : RecyclerView.Adapter<AdapterNewsUs.ViewHolder>() {

    class ViewHolder(var binding : ItemRecyclerUsBinding) : RecyclerView.ViewHolder(binding.root)

    private var listnewss: ArrayList<ArticlesItem> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun addDatanewss(xrplmenggabut: List<ArticlesItem>){
        listnewss.clear()
        listnewss.addAll(xrplmenggabut)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclerUsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataArticleberitaa = listnewss[position]
        holder.binding.txtJudulus.text = dataArticleberitaa.title
        holder.binding.txtAuthorus.text = dataArticleberitaa.author
        holder.binding.txtPublishedus.text = dataArticleberitaa.publishedAt
        holder.binding.imageViews.load(dataArticleberitaa.urlToImage){
            scale(Scale.FILL)
        }
        holder.itemView.setOnClickListener{
            val intent = Intent(it.context,DetailNewsUsActivity::class.java)
            intent.putExtra(DetailNewsUsActivity.TITLES,dataArticleberitaa.title)
            intent.putExtra(DetailNewsUsActivity.DESCRIPTIONS,dataArticleberitaa.description)
            intent.putExtra(DetailNewsUsActivity.SOURCES,dataArticleberitaa.source.toString())
            intent.putExtra(DetailNewsUsActivity.PUBLISHEDATS,dataArticleberitaa.publishedAt)
            intent.putExtra(DetailNewsUsActivity.IMGUS,dataArticleberitaa.urlToImage.toString())
            intent.putExtra(DetailNewsUsActivity.AUTHORS,dataArticleberitaa.author)
            intent.putExtra(DetailNewsUsActivity.CONTENTS,dataArticleberitaa.content)
            it.context.startActivity(intent)
        }
    }
    override fun getItemCount() = listnewss.size
    }