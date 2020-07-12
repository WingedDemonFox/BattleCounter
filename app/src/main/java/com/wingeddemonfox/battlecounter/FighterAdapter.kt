package com.wingeddemonfox.battlecounter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*

class FighterAdapter (private val items: ArrayList<Fighter>, private val context: Context) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item_row, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvFighter.text = items[position].fighterName
        holder.tvItemRoll.text = items[position].roll.toString()
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val tvFighter: TextView = view.item_title
    val tvItemRoll: TextView = view.itemRoll
}

data class Fighter(val fighterName: String, val roll: Int)