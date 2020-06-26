package com.wiprotest.demo.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.wiprotest.demo.R
import com.wiprotest.demo.model.Album
class DetailActivity : AppCompatActivity() {
    lateinit var photoIV: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        photoIV = findViewById(R.id.cv_iv_poster)
        val albumDetail = intent.getParcelableExtra<Album>("albumDetail")
        var artistTV: TextView = findViewById(R.id.artist)
        var albumTV: TextView = findViewById(R.id.abum_name)


        artistTV.text = albumDetail!!.artist
        albumTV.text = albumDetail!!.name

        var screenSize=intent.getStringExtra("screenSize")
        if(screenSize.equals("small")){
            Glide.with(this).load(albumDetail.image.get(0).text).into(photoIV)        }
        else if (screenSize.equals("medium")){
            Glide.with(this).load(albumDetail.image.get(0).text).into(photoIV)        }
        else if (screenSize.equals("large")){
            Glide.with(this).load(albumDetail.image.get(0).text).into(photoIV)
        }
        else if(screenSize.equals("extralarge")) {
            Glide.with(this).load(albumDetail.image.get(0).text).into(photoIV)
        }
    }

}