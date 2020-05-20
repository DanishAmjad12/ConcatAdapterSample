package com.sample.mergeadapter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sample.mergeadapter.MainActivity
import com.sample.mergeadapter.R
import com.sample.mergeadapter.models.User
import kotlinx.android.synthetic.main.item_layout_user.view.*

class UserAdapter(val context: MainActivity, var users: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.DataViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout_user, parent,
                false
            )
        )

    override fun getItemCount(): Int = users.size

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

        holder.itemView.textViewUserName.text = users[position].name

        Glide.with(holder.itemView.imageViewAvatar.context)
            .load(users[position].avatar)
            .into(holder.itemView.imageViewAvatar)

        holder.itemView.ivRemove.setOnClickListener {
            context.removeItem(position)
        }
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }




}
