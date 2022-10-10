package com.joelgh.aad_2022.ut01.ex03

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.joelgh.aad_2022.R
import com.joelgh.aad_2022.ut01.ex03.data.NewsLocalSource
import com.joelgh.aad_2022.ut01.ex03.domain.News

class Ut01Ex03Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01_ex03)
        initWithList()
    }

    private fun init(){
        val newsLocalSource = NewsLocalSource(getPreferences(Context.MODE_PRIVATE))

        val news1 = News(1, "Title1", "Subtitle1", "Summary1")
        val news2 = News(2, "Title2", "Subtitle2", "Summary2")
        val news3 = News(3, "Title3", "Subtitle3", "Summary3")

        newsLocalSource.setNews(news1)
        newsLocalSource.setNews(news2)
        newsLocalSource.setNews(news3)

        val foundNews = newsLocalSource.findById(2)

        Log.d("@dev", foundNews.toString())
    }

    private fun initWithList(){
        val newsLocalSource = NewsLocalSource(getPreferences(Context.MODE_PRIVATE))

        val newsList: MutableList<News> = mutableListOf<News>(
            News(1, "Title1", "Subtitle1", "Summary1"),
            News(1, "Title1", "Subtitle1", "Summary1"),
            News(1, "Title1", "Subtitle1", "Summary1")
        )

        newsLocalSource.setNewsList(newsList)

        val foundNews = newsLocalSource.getAll()

        Log.d("@dev", foundNews.toString())

    }

}