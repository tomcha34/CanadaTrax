package com.android.canadatrax


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import com.android.canadatrax.database.CloseContactData
import com.android.canadatrax.database.ContactsDao
import com.android.canadatrax.database.ContactsDatabase
import kotlinx.coroutines.GlobalScope

import kotlinx.coroutines.launch


class AddContactActivity : AppCompatActivity() {

    lateinit var firstNameText: EditText
    lateinit var lastNameText: EditText
    lateinit var phoneNumberText: EditText
    lateinit var emailText: EditText
    lateinit var contactDateText: EditText
    lateinit var contactsDao: ContactsDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        firstNameText = findViewById(R.id.firstName)
        lastNameText = findViewById(R.id.lastName)
        phoneNumberText = findViewById(R.id.phoneNumber)
        emailText = findViewById(R.id.email)
        contactDateText = findViewById(R.id.date)
        contactsDao = ContactsDatabase.getInstance(this)?.getContactsDao()!!


        val saveButton: Button = findViewById(R.id.saveButton)
        saveButton.setOnClickListener {
            val addContact = CloseContactData(
                firstNameText.text.toString(),
                lastNameText.text.toString(),
                phoneNumberText.text.toString(),
                emailText.text.toString(),
                contactDateText.text.toString()
            )
            if (addContact.firstName.isNullOrEmpty() && addContact.lastName.isNullOrEmpty() && addContact.contactDate.isNullOrEmpty()
                && addContact.email.isNullOrEmpty() && addContact.phoneNumber.isNullOrEmpty()){
                Toast.makeText(this, "Fields must not be left empty", Toast.LENGTH_SHORT).show()
            } else {
                GlobalScope.launch { insertContact(addContact) }
                Toast.makeText(this, "Contact Successfully Added", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }


    }

    suspend fun insertContact(addContact: CloseContactData) {

        contactsDao.insertContact(addContact)

    }
}

