package com.wiprotest.demo.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wiprotest.demo.R
import com.wiprotest.demo.model.Results

class AlbumAdapter(val results: Results, val screenSizeName: String): RecyclerView.Adapter<AlbumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.album_list_item, parent, false)
        return AlbumViewHolder(view)
    }

    override fun getItemCount(): Int {
       return results.albummatches.album.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        return holder.bind(results,screenSizeName)
    }

}
class AlbumViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

    private val photoIV: ImageView = itemView.findViewById(R.id.cv_iv_poster)
    private val artistTV:TextView = itemView.findViewById(R.id.artist)
    private val albumNameTV:TextView = itemView.findViewById(R.id.abum_name)

    fun bind(results: Results,screenSizeName : String) {
        if(screenSizeName.equals("small")){
            Glide.with(itemView.context).load(results.albummatches.album[layoutPosition].image.get(0).text).into(photoIV)
        }
            else if (screenSizeName.equals("medium")){
            Glide.with(itemView.context).load(results.albummatches.album[layoutPosition].image.get(1).text).into(photoIV)
        }
            else if (screenSizeName.equals("large")){
            Glide.with(itemView.context).load(results.albummatches.album[layoutPosition].image.get(2).text).into(photoIV)
        }
            else if(screenSizeName.equals("extralarge")) {
            Glide.with(itemView.context).load(results.albummatches.album[layoutPosition].image.get(3).text).into(photoIV)
        }

        artistTV.text = "Artist: "+results.albummatches.album[layoutPosition].artist
        albumNameTV.text = results.albummatches.album[layoutPosition].name
        itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra("albumDetail", results.albummatches.album[layoutPosition])
                intent.putExtra("screenSize",screenSizeName)
            itemView.context.startActivity(intent)
        }
    }


}