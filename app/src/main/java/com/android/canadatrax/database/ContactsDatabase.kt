package com.android.canadatrax.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CloseContactData::class], version = 1)
abstract class ContactsDatabase : RoomDatabase() {
    abstract fun getContactsDao(): ContactsDao?

    companion object {
        private const val DATABASE_NAME: String = "close_contacts_db"
        private var instance: ContactsDatabase? = null
        fun getInstance(context: Context?): ContactsDatabase? {
            if (instance == null) {
                if (context != null) {
                    instance = DATABASE_NAME.let {
                        Room.databaseBuilder(
                            context.applicationContext, ContactsDatabase::class.java,
                            it
                        ).build()
                    }
                }
            }
            return instance
        }
    }
}