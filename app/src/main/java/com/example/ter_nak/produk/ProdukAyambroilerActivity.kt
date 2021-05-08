package com.example.ter_nak.produk

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.viewpager.widget.ViewPager
import com.example.ter_nak.R
import com.example.ter_nak.SliderAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_produk_ayambroiler.*
import java.util.*

class ProdukAyambroilerActivity : AppCompatActivity() {
    private var currentPage = 0
    private var numPages = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produk_ayambroiler)

        val assets = listOf(
            R.drawable.ayambroiler01,
            R.drawable.ayambroiler02,
            R.drawable.ayambroiler03
        )

        createSlider(assets)

        // send
        val number = "6282271222110"
        val url: String = "https://api.whatsapp.com/send?phone=" + number
        beliBroiler.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setPackage("com.whatsapp")
            intent.setData(Uri.parse(url))
            startActivity(intent)
        }
    }

    private fun createSlider(string: List<Int>) {
        vpSliderBroiler.adapter = SliderAdapter(this, string)
        indicatorBroiler.setViewPager(vpSliderBroiler)
        val density = resources.displayMetrics.density
        //Set Circle indicator radius
        indicatorBroiler.radius = 5 * density
        numPages = string.size
        // Pager listener over indicator
        indicatorBroiler.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                currentPage = position
            }

            override fun onPageScrolled(pos: Int, arg1: Float, arg2: Int) {}
            override fun onPageScrollStateChanged(pos: Int) {}
        })
    }
}