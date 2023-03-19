package com.firstapp.moneymeter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.firstapp.moneymeter.databinding.CompoundinterestBinding


class CompoundInterest: AppCompatActivity() {

    lateinit var binding: CompoundinterestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CompoundinterestBinding.inflate(layoutInflater)
        setContentView(binding.root)
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

}