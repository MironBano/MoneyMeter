package com.firstapp.moneymeter

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.firstapp.moneymeter.databinding.ActivityCompoundinterestBinding

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
            doCalculation()
        }
    }

    private fun notEnoughData(){
        Toast.makeText(applicationContext, "Не все данные введены", Toast.LENGTH_SHORT).show()
    }
    private fun doCalculation(){
        if((binding.startAmount.text.toString() == "") || (binding.termAmount.text.toString() == "") || (binding.rateAmount.text.toString() == "")){
            notEnoughData()
            return
        }

        val startAm:Int = binding.startAmount.text.toString().toInt()
        val term:Int = binding.termAmount.text.toString().toInt()
        val rate:Int = binding.rateAmount.text.toString().toInt()
        var endAm:Float = startAm.toFloat()

        for(i in 1..term){
            endAm += (endAm / 100) * rate
        }

        binding.endAmount.text = endAm.toInt().toString()
        binding.endAmount.setTextColor(Color.parseColor("#FFFFFF"))
    }

}