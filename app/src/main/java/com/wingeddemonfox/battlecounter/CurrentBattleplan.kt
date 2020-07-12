package com.wingeddemonfox.battlecounter

class CurrentBattleplan {
    companion object{
        var currentInitiative = 0
        private var currentActivePc = ""
        var roundsPassed = 1
        var timePassed = 0
        var maxFightersInBattle = 0

        fun resetValues(){
            currentInitiative = 0
            currentActivePc = ""
            roundsPassed = 1
            timePassed = 0
            maxFightersInBattle = 0
        }
    }
}