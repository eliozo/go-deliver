package com.example.test1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Replace with your activity layout file name

//        val toolbar: Toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)

        val logoImageView: ImageView = findViewById(R.id.logoImageView)
        val registerButton: Button = findViewById(R.id.registerButton)
        val loginLinkTextView: TextView = findViewById(R.id.loginLinkTextView)

        // Set up your logo image
        // logoImageView.setImageResource(R.drawable.logo) // Replace with your logo image resource

        // Set up your register button
        registerButton.text = getString(R.string.register) // Use the "register" string from strings.xml

        // Register button click event
        registerButton.setOnClickListener {
            // Start the RegisterActivity
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // Set up your login link
        loginLinkTextView.text = getString(R.string.login) // Use the "login" string from strings.xml
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.pieslegsanasButton -> {
                // Handle the "pieslēgšanās" button click event
                // Start the LoginActivity or perform any desired action
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
