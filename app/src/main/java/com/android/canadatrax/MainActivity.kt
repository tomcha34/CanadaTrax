package com.android.canadatrax

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val covidButton : Button = findViewById(R.id.covidButton)
        val contactsButton : Button = findViewById(R.id.contactsButton)

        covidButton.setOnClickListener {
            val intent = Intent(this, CovidActivity::class.java)
            startActivity(intent)
        }

        contactsButton.setOnClickListener {
            val intent = Intent(this, ContactActivity::class.java)
            startActivity(intent)
        }
    }
}