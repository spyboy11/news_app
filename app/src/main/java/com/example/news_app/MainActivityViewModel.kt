package com.example.news_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.news_app.api_data.apiData

class MainActivityViewModel: ViewModel() {
    private var characterList: LiveData<PagedList<apiData>>? = null

    init {
        initPaging()
    }

    private fun initPaging(){
        val factory = apiDataSourceFactory()
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(1)
            .build()
    }

    fun getRecyclerListObserver(): LiveData<PagedList<apiData>>?{
        return characterList
    }
}