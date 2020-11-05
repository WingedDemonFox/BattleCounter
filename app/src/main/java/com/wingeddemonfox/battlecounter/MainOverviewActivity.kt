package com.wingeddemonfox.battlecounter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main_overview.*

class MainOverviewActivity : AppCompatActivity() {

    private val newFighterActivityRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_overview)

        if(fighters.size <= 0) {
            addFighters()
        }

        fighters.sortByDescending { it.roll }

        val rvFighters = findViewById<View>(R.id.memberOverview) as RecyclerView
        val adapter = FighterAdapter(fighters)
        rvFighters.adapter = adapter
        rvFighters.layoutManager = LinearLayoutManager(this)
        rvFighters.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        val fab = findViewById<FloatingActionButton>(R.id.addFighterFloat)
        fab.setOnClickListener{
            val intent = Intent(this@MainOverviewActivity, AddMembersAndOrderActivity::class.java)
            startActivityForResult(intent, newFighterActivityRequestCode)
        }
    }

    private fun addFighters(){
        fighters.add(Fighter("Player1",4))
        fighters.add(Fighter("Player2",12))
        fighters.add(Fighter("Player3", 8))
        fighters.add(Fighter("Player4", 18))
        fighters.add(Fighter("Player5", 17))
        fighters.add(Fighter("Player6", 15))
        fighters.add(Fighter("Player7", 10))
    }

    fun openAddFighter(view: View){
        val intent = Intent(this, AddMembersAndOrderActivity::class.java).apply{}
        startActivity(intent)
    }

    fun resetFighters(view: View){
        fighters.clear()
        (memberOverview.adapter as FighterAdapter).notifyDataSetChanged()
    }

    fun createNewBattleplan(view: View){

        if(fighters.size <= 0)
        {
            return
        }
        val intent = Intent(this, BattleInitiativeOverviewActivity::class.java).apply{}
        intent.putExtra("isNew", true)
        fighters.sortByDescending { it.roll }
        startActivity(intent)
    }

    fun updateBattleplan(view: View){

        if(fighters.size <= 0)
        {
            return
        }
        val intent = Intent(this, BattleInitiativeOverviewActivity::class.java).apply{}
        intent.putExtra("isNew", false)
        fighters.sortByDescending { it.roll }
        startActivity(intent)
    }

    companion object{
        val fighters = ArrayList<Fighter>()
    }
}
