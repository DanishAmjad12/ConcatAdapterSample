package com.sample.mergeadapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sample.mergeadapter.R
import com.sample.mergeadapter.models.Footer
import kotlinx.android.synthetic.main.item_layout_footer.view.*

class FooterAdapter(
    private val footer: Footer
) : RecyclerView.Adapter<FooterAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(footer: Footer) {

            Glide.with(itemView.imageViewFooter.context)
                .load(footer.footerImage)
                .into(itemView.imageViewFooter)
            
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout_footer, parent,
                false
            )
        )

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(footer)

}
