package com.example.test1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    val TAG = "RegisterActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val loginButton: Button = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            // Get the SharedPreferences instance
            val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

            // Get the SharedPreferences editor
            val editor = sharedPreferences.edit()

            var editTextUsername = findViewById(R.id.usernameEditText) as EditText
            var username = editTextUsername.text.toString()
            Log.i(TAG, "*********************************************")
            Log.i(TAG, "username is $username")
            var emailEditText = findViewById(R.id.emailEditText) as EditText
            var email = emailEditText.text.toString()
            var passwordEditText = findViewById(R.id.passwordEditText) as EditText
            var password = passwordEditText.text.toString()

            // Store the values using the username as the key
            editor.putString(username, "$email,$password")
            editor.apply()

            // Start the LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
