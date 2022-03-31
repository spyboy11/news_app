package com.example.news_app

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.news_app.api_data.apiData
import com.example.news_app.api_data.api_data_class
import com.example.news_app.api_data.retro_Instance
import com.example.news_app.api_data.retro_interface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class apiDataSource(): PageKeyedDataSource<Int, apiData>() {
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, apiData>) {
        val retroInstance = retro_Instance.getRetrofitInstance().create(retro_interface::class.java)
        val call = retroInstance.getDataFromApi(params.key)
        call.enqueue(object: Callback<api_data_class>{
            override fun onFailure(call: Call<api_data_class>, t: Throwable) {
                Log.e("apiUserDataSource", "Load After Failed")
            }

            override fun onResponse(call: Call<api_data_class>, response: Response<api_data_class>) {
                if (response.isSuccessful) {
                    callback.onResult(response?.body()?.articals!!, params.key)
                }
            }
        })
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, apiData>
    ) {
        val retroInstance = retro_Instance.getRetrofitInstance().create(retro_interface::class.java)
        val call = retroInstance.getDataFromApi(1)
        call.enqueue(object: Callback<api_data_class>{
            override fun onFailure(call: Call<api_data_class>, t: Throwable) {
                Log.e("apiUserDataSource", "Load After Failed")
            }

            override fun onResponse(call: Call<api_data_class>, response: Response<api_data_class>) {
                if (response.isSuccessful) {
                    callback.onResult(response?.body()?.articals!!, null, 50)
                }
            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, apiData>) {
        TODO("Not yet implemented")
    }
}

private fun Any.enqueue(callback: Callback<api_data_class>) {
    TODO("Not yet implemented")
}
