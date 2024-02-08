package com.firstapp.moneymeter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.view.forEach
import com.firstapp.moneymeter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var notReadyWarning: Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        notReadyWarning = Toast.makeText(applicationContext, "Раздел в разработке", Toast.LENGTH_SHORT)

        binding.root.forEach {
            if(it is Button) it.setOnClickListener(setUniversalListener())
        }
    }

    fun setUniversalListener() = View.OnClickListener {
        when(it.id) {
            R.id.compoundInterestButton -> startActivity(Intent(this@MainActivity, CompoundInterestActivity::class.java))
            R.id.inflationButton -> startActivity(Intent(this@MainActivity, InflationActivity::class.java))
            R.id.donatButton -> startActivity(Intent(this@MainActivity, RequisitesActivity::class.java))
            else -> {
                notReadyWarning.cancel()
                notReadyWarning.show()
            }
        }
    }
    
}