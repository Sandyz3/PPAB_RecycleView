package com.example.ppab_recycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ppab_recycleview.databinding.ActivityMainBinding
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    private lateinit var deskripsi: Array<String>
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        deskripsi = resources.getStringArray(R.array.list_deskripsi)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapterFigure = FigureAdapter(generateDummy(deskripsi)) { Figure ->
            val intentoDeskripsi = Intent(this@MainActivity, DetailPage::class.java)
            intentoDeskripsi.putExtra("IMAGE_URL", Figure.imageURL)
            intentoDeskripsi.putExtra("Figure_Name", Figure.nameFigure)
            intentoDeskripsi.putExtra("Figure_Price", Figure.priceFigure)
            intentoDeskripsi.putExtra("Figure_Description", Figure.detailFigure)
            startActivity(intentoDeskripsi)
        }

        with(binding) {
            rvFigure.apply {
                adapter = adapterFigure
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }
    }

    fun generateDummy(deskripsi: Array<String>): List<Figure> {
        return listOf(
            Figure(imageURL = "https://i.pinimg.com/564x/c6/a4/3f/c6a43f9c00f1ff50849f89ff7bacdec9.jpg", nameFigure = "Genshin Impact Yae Miko", priceFigure = "$ 130", detailFigure = deskripsi[0]),
            Figure(imageURL = "https://i.pinimg.com/564x/b5/d0/cf/b5d0cf802bfee7ff31ab5697ddeec7b8.jpg", nameFigure = "MDUP Marin Kitagawa", priceFigure = "$ 99", detailFigure  = deskripsi[1]),
            Figure(imageURL = "https://i.pinimg.com/564x/f5/02/45/f50245a5e151e5b6ff580a58f504c7a4.jpg", nameFigure = "NGO Chouzetsu Saikawa Tenshi-chan", priceFigure = "$ 121", detailFigure  = deskripsi[2]),
            Figure(imageURL = "https://i.pinimg.com/564x/36/31/eb/3631ebe13db6a93da690058afac2b9f1.jpg", nameFigure = "DS Shinobu Kocho", priceFigure= "$ 100", detailFigure  = deskripsi[3]),
            Figure(imageURL = "https://i.pinimg.com/564x/b6/18/a6/b618a66f7d1a2585d9efc65a57f6c4d7.jpg", nameFigure = "Hatsune Miku Expo 2019", priceFigure = "$ 112", detailFigure  = deskripsi[4]),
            Figure(imageURL = "https://i.pinimg.com/564x/01/ee/7c/01ee7c7ca5e9dda2be9745c10e2f51c7.jpg", nameFigure = "AOT Christiane", priceFigure= "$ 75", detailFigure = deskripsi[5]),
            Figure(imageURL = "https://i.pinimg.com/564x/1e/67/5d/1e675d0c8fc02e8d7389bff24a610f09.jpg", nameFigure = "BNHA Aoi Tsuyu", priceFigure = "$ 118", detailFigure  = deskripsi[6]),
            Figure(imageURL = "https://i.pinimg.com/564x/5a/43/92/5a4392aee71e7dce540ea7bc42b60fe4.jpg", nameFigure = "JJK Maki Zenin", priceFigure = "$ 85", detailFigure  = deskripsi[7]),
        )
    }
}



