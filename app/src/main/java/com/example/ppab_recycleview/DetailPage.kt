package com.example.ppab_recycleview

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.ppab_recycleview.databinding.ActivityDetailPageBinding


class DetailPage : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var image_url = intent.getStringExtra("IMAGE_URL")
        var name_figure = intent.getStringExtra("NAME_FIGURE")
        var price_figure = intent.getStringExtra("PRICE_FIGURE")
        var description_figure = intent.getStringExtra("DESCRIPTION_FIGURE")

        with(binding){
            nameFigure.text = name_figure
            priceFigure.text = "Harga : $price_figure"
            descriptionFigure.text = description_figure
            Glide.with(this@DetailPage)
                .load(image_url)
                .fitCenter()
                .into(binding.gambarDetail)
        }
    }
}