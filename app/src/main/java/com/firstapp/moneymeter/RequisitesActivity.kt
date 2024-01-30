package com.firstapp.moneymeter

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.firstapp.moneymeter.databinding.ActivityRequisitesBinding
import com.yandex.mobile.ads.banner.BannerAdSize
import com.yandex.mobile.ads.common.AdRequest

class RequisitesActivity: AppCompatActivity() {
    lateinit var binding: ActivityRequisitesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequisitesBinding.inflate(layoutInflater).also { setContentView(it.root) }


        binding.BottomBanner.setAdUnitId("demo-banner-yandex")
        binding.BottomBanner.setAdSize(BannerAdSize.inlineSize(applicationContext,350,100))
        val adRequest = AdRequest.Builder().build()
        binding.BottomBanner.loadAd(adRequest)

        with(binding){
            emailButton.setOnClickListener { showEmailRequisites() }
            donatButton.setOnClickListener { showDonatRequisites() }
            feedbackButton.setOnClickListener { showFeedBack() }
        }
    }

    private fun showEmailRequisites(){
        AlertDialog.Builder(this)
            .setTitle("Способы связи")
            .setMessage(R.string.emailRequisites)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                Toast.makeText(this, "Спасибо!", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    private fun showDonatRequisites(){
        AlertDialog.Builder(this)
            .setTitle("Способы поддержки")
            .setMessage(R.string.donatRequisites)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                Toast.makeText(this, "Спасибо!", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    private fun showFeedBack(){
        AlertDialog.Builder(this)
            .setTitle("Скоро в Play Market!")
            .setMessage("Пока что отзыв нельзя оставить в Google Play")
            .setPositiveButton(android.R.string.ok) { _, _ ->
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

}