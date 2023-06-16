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


        binding.compoundInterestButton.setOnClickListener{
            val intent = Intent(this@MainActivity, CompoundInterest::class.java)
            startActivity(intent)
        }

        binding.inflationButton.setOnClickListener{
            val intent = Intent(this@MainActivity, Inflation::class.java)
            startActivity(intent)
        }

        binding.donatButton.setOnClickListener{
            val intent = Intent(this@MainActivity, Requisites::class.java)
            startActivity(intent)
        }

        //binding.donatButton.setOnClickListener{
        //    notReadyWarning()
        //}

        binding.noteIcon.setOnClickListener{
            notReadyWarning()
        }

        binding.settingsButton.setOnClickListener{
            notReadyWarning()
        }

        binding.bondButton.setOnClickListener{
            notReadyWarning()
        }

        binding.stockButton.setOnClickListener{
            notReadyWarning()
        }

        binding.futureButton.setOnClickListener{
            notReadyWarning()
        }

        binding.convenorButton.setOnClickListener{
            notReadyWarning()
        }

        binding.creditButton.setOnClickListener{
            notReadyWarning()
        }

        binding.mortgageButton.setOnClickListener{
            notReadyWarning()
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

    private fun notReadyWarning(){
        Toast.makeText(applicationContext, "Раздел в разработке", Toast.LENGTH_SHORT).show()
    }
}