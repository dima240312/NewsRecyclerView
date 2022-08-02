package com.example.newsrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newsRecyclerView: RecyclerView
    private lateinit var newsArrayList: ArrayList<NewsData>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.nikolaev,
            R.drawable.sobchak,
            R.drawable.tiktokspotifyapplemusic,
            R.drawable.ios,
            R.drawable.xiaomi,
            R.drawable.unionpay
        )

        heading = arrayOf(
            "В Николаеве погиб бизнесмен из украинского списка Forbes",
            "Собчак сообщила о госпитализации Чубайса в одну из клиник Европы",
            "TikTok готовится к запуску \"убийцы\" Apple Music и Spotify",
            "В iOS 16 появилось удалённое управление гаджетами Apple через iPhone",
            "Xiaomi POCO C40 с чипом JR510 представлен в России по акционной цене от 9990 рублей",
            "МКБ и ДОМ.РФ планируют выпускать карты UnionPay в России"
        )

        newsRecyclerView = findViewById(R.id.NewsList)
        newsRecyclerView.layoutManager = LinearLayoutManager(this)
        newsRecyclerView.setHasFixedSize(true)

        newsArrayList = arrayListOf<NewsData>()
        getUserData()

    }

    private fun getUserData() {

        for (i in imageId.indices) {

            val news = NewsData(imageId[i], heading[i])
            newsArrayList.add(news)

        }

        newsRecyclerView.adapter = Adapter(newsArrayList)


    }
}