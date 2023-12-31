package com.dikamahard.gymify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.dikamahard.gymify.data.response.LoginResult
import com.dikamahard.gymify.databinding.ActivityLoginBinding
import com.dikamahard.gymify.helper.SessionPref

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lateinit var loginResult: LoginResult
        val pref = SessionPref(this)


        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]


        binding.tvRegisternow.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {
//            startActivity(Intent(this, MainActivity::class.java))
//            finish()
            val email = binding.etEmail.text.toString()
            val pw = binding.etPassword.text.toString()

            authenticate(email, pw)
//            startActivity(Intent(this, MainActivity::class.java))
        }

        viewModel.loginUser.observe(this) { response ->
            if (response?.error == false) {
                loginResult = response!!.data
                Log.d("LOGINACTIVITY", "onCreate: ${loginResult.token}")
                // then save user session and go to home page
                pref.loginUser(loginResult)
                // goto home page
                val intent: Intent = Intent(this, MainActivity::class.java)
                //intent.putExtra(MainActivity.EXTRA_TOKEN, loginResult.token)
                startActivity(intent)
                finish()
            }
        }

    }

    private fun authenticate(email: String, pw: String) {
        viewModel.loginUser(email, pw)
    }
}