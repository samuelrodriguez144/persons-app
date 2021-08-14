package com.guren.personsapp.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guren.personsapp.R
import com.guren.personsapp.model.PersonsModel
import com.guren.personsapp.ui.module.PersonDetailsActivity
import com.guren.personsapp.ui.viewholder.PersonViewHolder
import com.guren.personsapp.util.Constants

class PersonAdapter (
    private var ctx:Context,
    private var lists:MutableList<PersonsModel>):
    RecyclerView.Adapter<PersonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_person, parent, false)

        return PersonViewHolder(
            itemView
        )
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val item = lists[position]
        val firstString = item.firstName.first()

        holder.textLetter.text = firstString.toString()
        holder.textFirstName.text = item.firstName
        holder.textLastName.text = item.lastName
        holder.clPerson.setOnClickListener {

            val viewDetailIntent = Intent(ctx, PersonDetailsActivity::class.java)
            viewDetailIntent.putExtra(Constants.EXTRA_ITEM_DATA, item)
            ctx.startActivity(viewDetailIntent)
        }
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    fun clearList() {
        this.lists.clear()
        notifyDataSetChanged()
    }

    fun update(list: MutableList<PersonsModel>) {
        this.lists.addAll(list)
        notifyItemRangeInserted(this.lists.lastIndex, lists.size)
    }
}