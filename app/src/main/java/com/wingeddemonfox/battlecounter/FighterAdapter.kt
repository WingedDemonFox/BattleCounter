package com.wingeddemonfox.battlecounter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*

class FighterAdapter (private val fighters: ArrayList<Fighter>) :
    RecyclerView.Adapter<FighterAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return fighters.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val fighterView = inflater.inflate(R.layout.recyclerview_item_row, parent, false)
        return ViewHolder(fighterView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tvFighter = holder.tvFighter
        tvFighter.setText(fighters[position].fighterName)

        val tvItemRoll = holder.tvItemRoll
        tvItemRoll.setText(fighters[position].roll.toString())
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvFighter: TextView = view.item_title
        val tvItemRoll: TextView = view.itemRoll
    }

}


data class Fighter(val fighterName: String, val roll: Int)