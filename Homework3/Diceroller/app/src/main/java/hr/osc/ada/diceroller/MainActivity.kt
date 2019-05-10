package hr.osc.ada.diceroller

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }

    private fun initUI() {
        val dices = mutableListOf<ImageView>(viewDie1, viewDie2, viewDie3, viewDie4, viewDie5, viewDie6)
        var count=0

        actionRoll.setOnClickListener{
            rollDice(dices)
            count++
            checkCount(count)
        }

        dices.forEach { view ->
            view.setOnClickListener {
                if (count in 1..2) {
                    if (dices.contains(it)) {
                        it.setBackgroundColor(Color.parseColor("blue"))
                        dices.remove(it)
                    } else {
                        dices.add(it as ImageView)
                        it.setBackgroundColor(Color.parseColor("white"))
                    }
                }
            }
        }
    }

    private fun rollDice(dices: List<ImageView>) {
        dices.forEach{
            it.setImageResource(it.resources
                .getIdentifier("dice_${DiceRoller.roll()}", "drawable", "hr.osc.ada.diceroller"))
        }
    }

    private fun checkCount(count: Int) {
        when (count){
            1 -> showcount.text = getString(R.string.when1Text)
            2 -> showcount.text = getString(R.string.when2Text)
            3 -> showcount.text = getString(R.string.when3Text)
            else -> {
                showcount.text = getString(R.string.when4Text)
                reset()
            }
        }
    }

    private fun reset() {
        val dices = mutableListOf<ImageView>(viewDie1, viewDie2, viewDie3, viewDie4, viewDie5, viewDie6)
        var count=0
        dices.forEach{
            count++
            it.setBackgroundColor(Color.parseColor("white"))
            it.setImageResource(it.resources
                .getIdentifier("dice_$count", "drawable", "hr.osc.ada.diceroller"))
        }
        initUI()
    }

}
