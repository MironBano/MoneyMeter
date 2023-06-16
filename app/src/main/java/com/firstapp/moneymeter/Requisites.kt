package com.firstapp.moneymeter

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.firstapp.moneymeter.databinding.RequisitesBinding

class Requisites: AppCompatActivity() {
    lateinit var binding: RequisitesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RequisitesBinding.inflate(layoutInflater).also { setContentView(it.root) }


        with(binding){
            emailGroup.visibility = View.GONE
            donatGroup.visibility = View.GONE
        }

        binding.emailButton.setOnClickListener {
            showEmailRequisities()
        }

        binding.donatButton.setOnClickListener {
            showDonatRequisities()
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

    private fun showEmailRequisities(){
        binding.emailGroup.visibility = View.VISIBLE
    }

    private fun showDonatRequisities(){
        binding.donatGroup.visibility = View.VISIBLE
    }

}