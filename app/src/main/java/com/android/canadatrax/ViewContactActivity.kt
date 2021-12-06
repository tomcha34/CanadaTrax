package com.android.canadatrax

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.canadatrax.adapter.CloseContactAdapter
import com.android.canadatrax.database.CloseContactData
import com.android.canadatrax.database.ContactsDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_contact)
        val contactsDao = ContactsDatabase.getInstance(this)?.getContactsDao()!!

        val recyclerView = findViewById<RecyclerView>(R.id.list)


        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                val closeContacts = contactsDao.getAll()
                runOnUiThread {
                    recyclerView.adapter = CloseContactAdapter(closeContacts)
                }

            }
        }

    }
}
