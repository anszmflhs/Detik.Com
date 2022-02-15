package com.example.detikcom.Adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.detikcom.Model.ArticlesItem
import com.example.detikcom.activity.DetailSportActivity
import com.example.detikcom.databinding.ItemRecyclerSportBinding

class AdapterSport : RecyclerView.Adapter<AdapterSport.ViewHolder>() {
    class ViewHolder(var binding: ItemRecyclerSportBinding) : RecyclerView.ViewHolder(binding.root)

    private var listsport : ArrayList<ArticlesItem> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun addDataSport(xrplndes : List<ArticlesItem>){
        listsport.clear()
        listsport.addAll(xrplndes)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclerSportBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataArticleSport = listsport[position]
        holder.binding.txtJudulsport.text = dataArticleSport.title
        holder.binding.txtAuthorsport.text = dataArticleSport.author
        holder.binding.txtPublishedsport.text = dataArticleSport.publishedAt
        holder.binding.imgSport.load(dataArticleSport.urlToImage) {
            scale(Scale.FILL)
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context,DetailSportActivity::class.java)
            intent.putExtra(DetailSportActivity.TITLE,dataArticleSport.title)
            intent.putExtra(DetailSportActivity.DESCRIPTION,dataArticleSport.description)
            intent.putExtra(DetailSportActivity.SOURCE,dataArticleSport.source.toString())
            intent.putExtra(DetailSportActivity.PUBLISHAT,dataArticleSport.publishedAt)
            intent.putExtra(DetailSportActivity.IMG,dataArticleSport.urlToImage.toString())
            intent.putExtra(DetailSportActivity.AUTHOR,dataArticleSport.author)
            intent.putExtra(DetailSportActivity.CONTENT,dataArticleSport.content)
            it.context.startActivity(intent)
        }
    }
    override fun getItemCount() = listsport.size
    }