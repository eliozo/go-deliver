package com.example.test1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    val TAG = "LoginActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

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
            var passwordEditText = findViewById(R.id.passwordEditText) as EditText
            var password = passwordEditText.text.toString()

            // Store the values using the username as the key
//            editor.putString(username, "$email,$password")
//            editor.apply()

            var loginSuccessful:Boolean = true


            // Retrieve the stored values for a given username
            val storedValues = sharedPreferences.getString(username, null)

            // Check if the values exist
            if (storedValues != null) {
                val values = storedValues.split(",")

                // Retrieve the email and password
                val storedEmail = values[0]
                val storedPassword = values[1]
                Log.i(TAG, "Stored password is $storedPassword")
                if (password == storedPassword){
                    loginSuccessful = true
                }
            }

            when (loginSuccessful) {
                true -> {
                    Toast.makeText(this@LoginActivity, "Login was successful", Toast.LENGTH_LONG).show()
                    // Start the MapActivity
                    val intent = Intent(this, MapActivity::class.java)
                    startActivity(intent)
                }
                false -> {
                    Toast.makeText(this@LoginActivity, "Login failed", Toast.LENGTH_LONG).show()
                    // Start the LoginActivity
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

}
