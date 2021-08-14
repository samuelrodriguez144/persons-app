package com.guren.personsapp.ui.viewholder

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.guren.personsapp.R

class  PersonViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

    val clPerson        : ConstraintLayout = itemView.findViewById(R.id.cl_person)
    val textFirstName   : TextView = itemView.findViewById(R.id.text_fname)
    val textLastName    : TextView = itemView.findViewById(R.id.text_lname)
    val textLetter      : TextView = itemView.findViewById(R.id.text_letter)

}