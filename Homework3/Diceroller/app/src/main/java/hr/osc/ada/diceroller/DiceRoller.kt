package hr.osc.ada.diceroller

import kotlin.random.Random

object DiceRoller {
    private val random = Random
    fun roll() = random.nextInt(1,7)
}