package com.firstapp.moneymeter

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.firstapp.moneymeter.databinding.ActivityInflatonBinding
import kotlin.math.roundToInt

class InflationActivity: AppCompatActivity() {
    lateinit var binding: ActivityInflatonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInflatonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.termSlider.addOnChangeListener { _, value, _ ->
            binding.textTermNumber.text = value.toInt().toString() + " лет"
        }

        binding.rateSlider.addOnChangeListener { _, value, _ ->
            binding.textRateNumber.setText(value.roundToInt().toString())
        }

        binding.calcButton.setOnClickListener{
            binding.endAmount.text = doCalculation().toString()
        }

    }

    private fun notEnoughData(){
        Toast.makeText(applicationContext, "Не все данные введены", Toast.LENGTH_SHORT).show()
    }

    private fun doCalculation(): Double{

        if((binding.startAmount.text.toString() == "") || (binding.textTermNumber.text.toString() == "") || (binding.textRateNumber.text.toString() == "")){
            notEnoughData()
            return 0.0
        }

        val startAm:Int = binding.startAmount.text.toString().toInt()
        val term:Int = binding.textTermNumber.text.removeSuffix(" лет").toString().toInt()
        val rate:Double = binding.textRateNumber.text.toString().toDouble()
        var endAm:Double = startAm.toDouble()

        for(i in 1..term){
            endAm -= (endAm / 100) * rate
        }
        return (endAm * 100).roundToInt() / 100.0
    }

}