package com.firstapp.moneymeter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.firstapp.moneymeter.databinding.BondsBinding

class Bonds: AppCompatActivity() {

    lateinit var binding: BondsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BondsBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}