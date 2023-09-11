package com.firstapp.moneymeter

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.firstapp.moneymeter.databinding.RequisitesBinding
import com.yandex.mobile.ads.banner.BannerAdSize
import com.yandex.mobile.ads.common.AdRequest

class Requisites: AppCompatActivity() {
    lateinit var binding: RequisitesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RequisitesBinding.inflate(layoutInflater).also { setContentView(it.root) }


        binding.BottomBanner.setAdUnitId("demo-banner-yandex")
        binding.BottomBanner.setAdSize(BannerAdSize.inlineSize(applicationContext,350,100))
        val adRequest = AdRequest.Builder().build()
        binding.BottomBanner.loadAd(adRequest)

        binding.emailButton.setOnClickListener {
            showEmailRequisities()
        }

        binding.donatButton.setOnClickListener {
            showDonatRequisities()
        }

        binding.feedbackButton.setOnClickListener {
            showFeedBack()
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
        AlertDialog.Builder(this)
            .setTitle("Способы связи")
            .setMessage(R.string.emailRequisites)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                Toast.makeText(this, "Спасибо!", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    private fun showDonatRequisities(){
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