package com.wingeddemonfox.battlecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.children
import com.wingeddemonfox.battlecounter.ShowMemberAndOrderOverviewActivity.Companion.fighters

class BattleInitiativeOverviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battle_initiative_overview)

        val isNew = intent.getBooleanExtra("isNew", true)
        if(isNew)
        {
            CurrentBattleplan.resetValues()
        }

        buildBattleOverview()
        updateBattleValuesOnView()
        updateEnablingButtons()
    }

    private fun buildBattleOverview(){
        val linearLayout = findViewById<LinearLayout>(R.id.buttonsLayout)
        CurrentBattleplan.maxFightersInBattle = fighters.size
        for(fighter in fighters){
            createButtons(fighter.fighterName, linearLayout)
        }
    }

    private fun createButtons(text: String, linearLayout: LinearLayout){
        val fighterButton = Button(this)
        fighterButton.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        fighterButton.text = text
        fighterButton.textSize = 40F
        fighterButton.setOnClickListener{onClickFighter()}
        linearLayout.addView(fighterButton)
    }

    private fun onClickFighter(){
        ++CurrentBattleplan.currentInitiative

        if(CurrentBattleplan.currentInitiative >= CurrentBattleplan.maxFightersInBattle)
        {
            CurrentBattleplan.currentInitiative = 0
            CurrentBattleplan.timePassed += 6
            CurrentBattleplan.roundsPassed += 1
        }
        updateBattleValuesOnView()
        updateEnablingButtons()
    }

    private fun updateBattleValuesOnView(){
        findViewById<TextView>(R.id.roundsPassed).apply{
            text = CurrentBattleplan.roundsPassed.toString()
        }

        findViewById<TextView>(R.id.timePassed).apply{
            text = CurrentBattleplan.timePassed.toString() + " seconds"
        }
    }

    private fun updateEnablingButtons(){
        val linearLayout = findViewById<LinearLayout>(R.id.buttonsLayout)
        linearLayout.children.forEach { b ->b.isEnabled = false }

        linearLayout.children.elementAt(CurrentBattleplan.currentInitiative).isEnabled = true

        findViewById<TextView>(R.id.activeFighter).apply{
            text = (linearLayout.children.elementAt(CurrentBattleplan.currentInitiative) as Button).text.toString()
        }
    }


}