package com.firstapp.moneymeter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.firstapp.moneymeter.databinding.ActivityBondsBinding

class BondsActivity: AppCompatActivity() {

    lateinit var binding: ActivityBondsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBondsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}