package com.dikamahard.gymify.ui.scan

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dikamahard.gymify.data.api.ApiConfig
import com.dikamahard.gymify.data.response.ScanResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ScanViewModel : ViewModel(){

    companion object {
        val TAG = "SCANVIEWMODEL"
    }


    private val _scanPhoto = MutableLiveData<ScanResponse?>()
    val scanPhoto: LiveData<ScanResponse?> = _scanPhoto

    fun scanPhoto(token: String, file: MultipartBody.Part, predictedname: String) {

        val client = ApiConfig.getApiService().scan(token, file, predictedname)
        client.enqueue(object :Callback<ScanResponse> {
            override fun onResponse(call: Call<ScanResponse>, response: Response<ScanResponse>) {
                val responseBody = response.body()
                if (response.isSuccessful) {
                    _scanPhoto.value = responseBody
                    _scanPhoto.value = null
                }else {
                    Log.e(TAG, "onResponse: ${response.message()}", )
                }
            }

            override fun onFailure(call: Call<ScanResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }

        })
    }

}