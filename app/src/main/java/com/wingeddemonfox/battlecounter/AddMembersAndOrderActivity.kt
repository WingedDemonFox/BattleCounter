package com.wingeddemonfox.battlecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible
import com.wingeddemonfox.battlecounter.ShowMemberAndOrderOverviewActivity.Companion.fighters

//use this to add member and order
class AddMembersAndOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_members_and_order)

        val textView = findViewById<AutoCompleteTextView>(R.id.addFighterName)
        val pcs: Array<out String> = resources.getStringArray(R.array.PCs)
        ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pcs).also { adapter ->
            textView.setAdapter(adapter)
        }
    }


    fun addFighterToList(view: View){
        val fighterName = findViewById<EditText>(R.id.addFighterName)
        val fighterRoll = findViewById<EditText>(R.id.addFighterRoll)

        val fighterNameText = fighterName.text.toString().trim()
        val fighterRollText = fighterRoll.text.toString().toInt()


        fighters.add(Fighter(fighterNameText.trim(), fighterRollText))

        fighterName.text = null
        fighterRoll.text = null
        val notification = findViewById<TextView>(R.id.notification)
        notification.text =
            "Added Fighter $fighterNameText with initiative roll $fighterRollText. Click Back-Button to go back."
        notification.isVisible = true
    }
}