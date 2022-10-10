package com.joelgh.aad_2022.ut01.ex03.data

import android.content.SharedPreferences
import com.google.gson.Gson
import com.joelgh.aad_2022.ut01.ex03.domain.News

class NewsLocalSource(val sharedPref: SharedPreferences) {

    fun setNews(news: News){

        val gson = Gson()
        val jsonNews = gson.toJson(news)

        val editor = sharedPref.edit()

        editor.putString(news.id.toString(), jsonNews)
        editor.apply()
    }

    fun findById(newsId: Int): News{
        val gson = Gson()

        val jsonNews = sharedPref.getString(newsId.toString(),"")

        return gson.fromJson(jsonNews, News::class.java)
    }

    fun setNewsList(mutableList: MutableList<News>){
        val gson = Gson()

        val jsonNewsList = gson.toJson(mutableList)

        val editor = sharedPref.edit()
        editor.putString("1",jsonNewsList)
        editor.apply()
    }

    fun getAll(): MutableList<News>{
        val gson = Gson()
        return sharedPref.all.map{entry ->
            gson.fromJson(entry.value as String, News::class.java)
        }.toMutableList()
    }
}