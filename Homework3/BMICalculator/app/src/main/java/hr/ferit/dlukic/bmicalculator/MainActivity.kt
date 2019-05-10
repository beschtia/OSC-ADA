package hr.ferit.dlukic.bmicalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }

    private fun initUI() {
        etHeight.addTextChangedListener(CheckMaxValue(2.5))
        etWeight.addTextChangedListener(CheckMaxValue(350.0))

        actionCalculateBMI.setOnClickListener {
             when {
                etHeight.text.isBlank() -> displayToast(getString(R.string.noInputHeight))
                etWeight.text.isBlank() -> displayToast(getString(R.string.noInputWeight))
                else -> {
                    val height = etHeight.text.toString().toDouble()
                    val weight = etWeight.text.toString().toDouble()
                    when {
                        height < 0.2 -> displayToast(getString(R.string.heightInputSmall))
                        weight < 2.0 -> displayToast(getString(R.string.weightInputSmall))
                        else -> {
                            setViews(height, weight)
                        }
                    }
                }
            }
        }
    }

    private fun setViews(height: Double, weight: Double) {
        val hashMap = getTextViewTexts(calculateBMI(height, weight))

        tvResult.text = hashMap["bmi"]
        tvHeader.setText(
            getStringResourceID(hashMap["header"])
        )
        tvDescription.setText(
            getStringResourceID(hashMap["description"])
        )
        ivPicture.setImageResource(
           getImageResourceID(hashMap["image"])
        )
    }
}
