package com.android.canadatrax.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.canadatrax.R
import com.android.canadatrax.database.CloseContactData

class CloseContactAdapter(private val values: List<CloseContactData>) :
    RecyclerView.Adapter<CloseContactAdapter.ViewHolder>() {

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val firstNameView: TextView = view.findViewById(R.id.firstNameShow)

        val dateView: TextView = view.findViewById(R.id.dateShow)
        val phoneView: TextView = view.findViewById(R.id.phoneShow)
        val emailView: TextView = view.findViewById(R.id.emailShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.firstNameView.text = item.firstName + " " + item.lastName
        holder.dateView.text = item.contactDate
        holder.phoneView.text = item.phoneNumber
        holder.emailView.text = item.email
    }

    override fun getItemCount(): Int {
        return values.size
    }
}