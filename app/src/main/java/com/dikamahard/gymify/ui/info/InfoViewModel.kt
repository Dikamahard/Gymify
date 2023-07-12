package com.dikamahard.gymify.ui.info

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dikamahard.gymify.LoginViewModel
import com.dikamahard.gymify.data.api.ApiConfig
import com.dikamahard.gymify.data.response.LoginResponse
import com.dikamahard.gymify.data.response.LogoutResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InfoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is info Fragment"
    }
    val text: LiveData<String> = _text


    private val _logoutUser = MutableLiveData<LogoutResponse?>()
    val logoutUser: MutableLiveData<LogoutResponse?> = _logoutUser

    fun logoutUser(token: String) {
        val client = ApiConfig.getApiService().logout(token)
        client.enqueue(object: Callback<LogoutResponse> {
            override fun onResponse(
                call: Call<LogoutResponse>,
                response: Response<LogoutResponse>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful) {
                    _logoutUser.value = responseBody
                    Log.d(LoginViewModel.TAG, "onResponse: berhasil")
                }else {
                    Log.e(LoginViewModel.TAG, "onResponse else: ${response.message()} ", )
                }
            }

            override fun onFailure(call: Call<LogoutResponse>, t: Throwable) {
                Log.e(LoginViewModel.TAG, "onFailure: ${t.message} ", )
            }

        })
    }
}