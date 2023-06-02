package com.firstapp.moneymeter

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.firstapp.moneymeter.databinding.CompoundinterestBinding
class CompoundInterest: AppCompatActivity() {

    lateinit var binding: CompoundinterestBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = CompoundinterestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.expandButton.setOnClickListener {
            val intent = Intent(this@CompoundInterest, CompoundInteresttest::class.java)
            startActivity(intent)
        }

        binding.calcButton.setOnClickListener {
            doCalculation()
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

    private fun doCalculation(){
        if((binding.startAmount.text.toString() == "") || (binding.termAmount.text.toString() == "") || (binding.rateAmount.text.toString() == "")){
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