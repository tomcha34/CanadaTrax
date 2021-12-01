package com.android.canadatrax

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val covidButton : Button = findViewById(R.id.covidButton)
        val addContactsButton : Button = findViewById(R.id.contactsButton)
        val viewContactsButton : Button = findViewById(R.id.viewContacts)

        covidButton.setOnClickListener {
            val intent = Intent(this, CovidActivity::class.java)
            startActivity(intent)
        }

        addContactsButton.setOnClickListener {
            val intent = Intent(this, AddContactActivity::class.java)
            startActivity(intent)
        }

        viewContactsButton.setOnClickListener {
            val intent = Intent(this, ViewContactActivity::class.java)
            startActivity(intent)
        }
    }
}