package com.firstapp.moneymeter

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.firstapp.moneymeter.databinding.CompoundinterestBinding
import com.firstapp.moneymeter.databinding.CompoundinteresttestBinding
import com.google.android.material.slider.Slider


class CompoundInterest: AppCompatActivity() {

    lateinit var binding: CompoundinteresttestBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = CompoundinteresttestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.group2.visibility = View.GONE

        binding.termSlider.addOnChangeListener { slider, value, fromUser ->
            binding.textTermNumber.text = value.toInt().toString() + " лет"
        }

        binding.rateSlider.addOnChangeListener { slider, value, fromUser ->
            binding.textRateNumber.text = value.toInt().toString() + " %"
        }


        binding.plusButton.setOnClickListener{
            showAddAtt()
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

    private fun showAddAtt(){

        with(binding){
            group2.visibility = View.VISIBLE
        }
    }
}