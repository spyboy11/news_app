package com.example.news_app

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.news_app.api_data.apiData
import com.example.news_app.api_data.api_data_class

class apiDataSourceFactory(): DataSource.Factory<Int, apiData>() {

    private var mutableLiveData: MutableLiveData<apiData>? = null

    init {
        mutableLiveData = MutableLiveData()
    }

    override fun create(): DataSource<Int, apiData> {
        val userDataSource = apiDataSource()
        mutableLiveData?.postValue(userDataSource)
        return userDataSource
    }
}

private fun Any?.postValue(userDataSource: apiDataSource) {
    TODO("Not yet implemented")
}