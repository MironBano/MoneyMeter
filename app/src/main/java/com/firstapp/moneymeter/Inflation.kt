package com.firstapp.moneymeter

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.firstapp.moneymeter.databinding.InflatonBinding

class Inflation: AppCompatActivity() {
    lateinit var binding: InflatonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = InflatonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.termSlider.addOnChangeListener { slider, value, fromUser ->
            binding.textTermNumber.text = value.toInt().toString() + " лет"
        }

        binding.rateSlider.addOnChangeListener { slider, value, fromUser ->
            binding.textRateNumber.text = value.toInt().toString() + " %"
        }

        binding.calcButton.setOnClickListener{
            amountChanger()
        }

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun amountChanger(){
        binding.startAmount.text = binding.InitAmount.text.toString()

        val startAm:Int = binding.InitAmount.text.toString().toInt()
        val term:Int = binding.textTermNumber.text.removeSuffix(" лет").toString().toInt()
        val rate:Int = binding.textRateNumber.text.removeSuffix(" %").toString().toInt()
        var endAm:Float = startAm.toFloat()
        for(i in 1..term){
            endAm -= (endAm / 100) * rate
        }
        binding.endAmount.text = endAm.toInt().toString()
    }

}