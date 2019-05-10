package hr.ferit.dlukic.bmicalculator

import android.content.Context
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.collections.HashMap

fun calculateBMI(height: Double, weight: Double):Double = weight/(height*height)

fun getTextViewTexts(bmi: Double): HashMap<String,String>{
    val hashMap = hashMapOf("bmi" to BigDecimal(bmi.toString()).setScale(2,RoundingMode.HALF_UP).toString())
    when (bmi) {
        in 0.0..18.5 -> {
            hashMap["header"] = "tvUnderweight"
            hashMap["description"] = "tvUnderweightDescription"
            hashMap["image"] = "underweight"
        }
        in 18.5..25.0 -> {
            hashMap["header"] = "tvNormal"
            hashMap["description"] = "tvNormalDescription"
            hashMap["image"] = "normal"

        }
        in 25.0..30.0 -> {
            hashMap["header"] = "tvOverweight"
            hashMap["description"] = "tvOverweightDescription"
            hashMap["image"] = "overweight"

        }
        else -> {
            hashMap["header"] = "tvObese"
            hashMap["description"] = "tvObeseDescription"
            hashMap["image"] = "obese"

        }
    }
    return hashMap
}

fun Context.getStringResourceID(string: String?) = resources.getIdentifier(string, "string", "hr.ferit.dlukic.bmicalculator")
fun Context.getImageResourceID(string: String?) = resources.getIdentifier(string, "drawable", "hr.ferit.dlukic.bmicalculator")