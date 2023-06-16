package com.firstapp.moneymeter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.firstapp.moneymeter.databinding.RequisitesBinding

class Requisites: AppCompatActivity() {
    lateinit var binding: RequisitesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RequisitesBinding.inflate(layoutInflater).also { setContentView(it.root) }


    }


}