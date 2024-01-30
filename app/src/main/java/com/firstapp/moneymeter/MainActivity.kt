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

        with(binding){
            compoundInterestButton.setOnClickListener{
                val intent = Intent(this@MainActivity, CompoundInterestActivity::class.java)
                notReadyWarning.cancel()
                startActivity(intent)
            }
            inflationButton.setOnClickListener{
                val intent = Intent(this@MainActivity, InflationActivity::class.java)
                notReadyWarning.cancel()
                startActivity(intent)
            }
            donatButton.setOnClickListener{
                val intent = Intent(this@MainActivity, RequisitesActivity::class.java)
                notReadyWarning.cancel()
                startActivity(intent)
            }
            noteIcon.setOnClickListener{
                notReadyWarning.cancel()
                notReadyWarning.show()
            }
            bondButton.setOnClickListener{
                notReadyWarning.cancel()
                notReadyWarning.show()
            }
            stockButton.setOnClickListener{
                notReadyWarning.cancel()
                notReadyWarning.show()
            }
            futureButton.setOnClickListener{
                notReadyWarning.cancel()
                notReadyWarning.show()
            }
            creditButton.setOnClickListener{
                notReadyWarning.cancel()
                notReadyWarning.show()
            }
            mortgageButton.setOnClickListener{
                notReadyWarning.cancel()
                notReadyWarning.show()
            }
            settingsButton.setOnClickListener{
                notReadyWarning.cancel()
                notReadyWarning.show()
            }
        }
    }

    override fun onStop() {
        super.onStop()
    }
    
}