package com.firstapp.moneymeter

import android.os.Bundle
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

        binding.termSlider.addOnChangeListener { slider, value, fromUser ->
            binding.textTermNumber.text = value.toInt().toString() + " лет"
        }

        fun onStart() {
            super.onStart()
        }

        fun onResume() {
            super.onResume()
        }

        fun onPause() {
            super.onPause()
        }

        fun onStop() {
            super.onStop()
        }

        fun onDestroy() {
            super.onDestroy()
        }

    }
}