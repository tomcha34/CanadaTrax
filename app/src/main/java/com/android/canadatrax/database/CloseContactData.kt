package com.android.canadatrax.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "close_contacts_db")
data class CloseContactData(
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?,
    @ColumnInfo(name = "phone_number") val phoneNumber: String?,
    @ColumnInfo(name = "email") val email: String?,
    @ColumnInfo(name = "date_of_contact") val contactDate: String?
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}

class Constants {
    companion object {
        const val DATABASE_NAME = "close_contacts_db"
    }
}
