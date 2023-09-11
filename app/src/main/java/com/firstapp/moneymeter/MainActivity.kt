package com.firstapp.moneymeter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.firstapp.moneymeter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        val notReadyWarning = Toast.makeText(applicationContext, "Раздел в разработке", Toast.LENGTH_SHORT)

        binding.compoundInterestButton.setOnClickListener{
            val intent = Intent(this@MainActivity, CompoundInterest::class.java)
            notReadyWarning.cancel()
            startActivity(intent)
        }

        binding.inflationButton.setOnClickListener{
            val intent = Intent(this@MainActivity, Inflation::class.java)
            notReadyWarning.cancel()
            startActivity(intent)
        }

        binding.donatButton.setOnClickListener{
            val intent = Intent(this@MainActivity, Requisites::class.java)
            notReadyWarning.cancel()
            startActivity(intent)
        }

        //binding.donatButton.setOnClickListener{
        //    notReadyWarning.show()
        //}

        binding.noteIcon.setOnClickListener{
            notReadyWarning.cancel()
            notReadyWarning.show()
        }

        binding.settingsButton.setOnClickListener{
            notReadyWarning.cancel()
            notReadyWarning.show()
        }

        binding.bondButton.setOnClickListener{
            notReadyWarning.cancel()
            notReadyWarning.show()
        }

        binding.stockButton.setOnClickListener{
            notReadyWarning.cancel()
            notReadyWarning.show()
        }

        binding.futureButton.setOnClickListener{
            notReadyWarning.cancel()
            notReadyWarning.show()
        }

        binding.convenorButton.setOnClickListener{
            notReadyWarning.cancel()
            notReadyWarning.show()
        }

        binding.creditButton.setOnClickListener{
            notReadyWarning.cancel()
            notReadyWarning.show()
        }

        binding.mortgageButton.setOnClickListener{
            notReadyWarning.cancel()
            notReadyWarning.show()
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
    
}