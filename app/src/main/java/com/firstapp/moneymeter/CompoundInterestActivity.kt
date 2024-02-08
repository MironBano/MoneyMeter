package com.firstapp.moneymeter

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.firstapp.moneymeter.databinding.ActivityCompoundinterestBinding
import kotlin.math.roundToInt

class CompoundInterestActivity: AppCompatActivity() {

    lateinit var binding: ActivityCompoundinterestBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityCompoundinterestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.expandButton.setOnClickListener {
            val intent = Intent(this@CompoundInterestActivity, CompoundInteresttestActivity::class.java)
            startActivity(intent)
        }

        binding.calcButton.setOnClickListener {
            binding.endAmount.text = doCalculation().toString()
            binding.endAmount.setTextColor(Color.parseColor("#FFFFFF"))
        }
    }

    private fun notEnoughData(){
        Toast.makeText(applicationContext, "Не все данные введены", Toast.LENGTH_SHORT).show()
    }

    private fun doCalculation(): Double{
        if((binding.startAmount.text.toString() == "") || (binding.termAmount.text.toString() == "") || (binding.rateAmount.text.toString() == "")){
            notEnoughData()
            return 0.0
        }

        val startAm:Int = binding.startAmount.text.toString().toInt()
        val term:Int = binding.termAmount.text.toString().toInt()
        val rate:Double = binding.rateAmount.text.toString().toDouble()
        var endAm:Double = startAm.toDouble()

        for(i in 1..term){
            endAm += (endAm / 100) * rate
        }
        return (endAm * 100).roundToInt() / 100.0
    }

}