package com.android.canadatrax.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

    @Dao
    interface ContactsDao {
        @Query("SELECT * FROM close_contacts_db")
       fun getAll(): List<CloseContactData>


        @Insert
       suspend fun insertContact(vararg contacts: CloseContactData)

        @Delete
       suspend fun delete(contacts: CloseContactData)
    }
