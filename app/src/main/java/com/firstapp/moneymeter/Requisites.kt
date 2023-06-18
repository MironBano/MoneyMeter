package com.firstapp.moneymeter

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.firstapp.moneymeter.databinding.RequisitesBinding
import com.yandex.mobile.ads.banner.AdSize
import com.yandex.mobile.ads.common.AdRequest

class Requisites: AppCompatActivity() {
    lateinit var binding: RequisitesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RequisitesBinding.inflate(layoutInflater).also { setContentView(it.root) }


        binding.topBanner.setAdUnitId("demo-banner-yandex")
        binding.topBanner.setAdSize(AdSize.inlineSize(350,70))
        val adRequest = AdRequest.Builder().build()
        binding.topBanner.loadAd(adRequest)

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