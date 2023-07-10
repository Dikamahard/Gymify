package com.dikamahard.gymify.ui.history

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dikamahard.gymify.data.api.ApiConfig
import com.dikamahard.gymify.data.response.HistoryItem
import com.dikamahard.gymify.data.response.ListHistoryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoryViewModel : ViewModel() {

    companion object {
        val TAG = "HISTORYVIEWMODEL"
    }

    private val _listHistory = MutableLiveData<List<HistoryItem>>()
    val listHistory: LiveData<List<HistoryItem>> = _listHistory

    fun getUserHistory(token: String) {

        val client = ApiConfig.getApiService().getHistory(token)
        client.enqueue(object: Callback<ListHistoryResponse> {
            override fun onResponse(
                call: Call<ListHistoryResponse>,
                response: Response<ListHistoryResponse>
            ) {
                val responseBody = response.body()
                if(response.isSuccessful) {
                    _listHistory.value = responseBody?.history
                }else {
                    Log.e(TAG, "onResponse: ${response.message()}", )
                }
            }

            override fun onFailure(call: Call<ListHistoryResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}", )

            }

        })
    }
}