package com.firstapp.moneymeter

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.firstapp.moneymeter.databinding.CompoundinteresttestBinding

class CompoundInteresttest: AppCompatActivity() {

    lateinit var binding: CompoundinteresttestBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = CompoundinteresttestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.group1.visibility = View.GONE
        binding.group2.visibility = View.GONE
        binding.group3.visibility = View.GONE
        binding.taxElements.visibility = View.GONE
        binding.reinvestmentElements.visibility = View.GONE

        binding.termSlider.addOnChangeListener { slider, value, fromUser ->
            binding.textTermNumber.text = value.toInt().toString() + " лет"
        }

        binding.rateSlider.addOnChangeListener { slider, value, fromUser ->
            binding.textRateNumber.text = value.toInt().toString() + " %"
        }

        binding.plusButton.setOnClickListener {
            showAddAtt()
        }

        binding.calcButton.setOnClickListener{
            analiticsChanger()
        }

        binding.cross2.setOnClickListener{
            binding.group2.visibility = View.GONE
        }

        binding.cross3.setOnClickListener{
            binding.group3.visibility = View.GONE
        }

        binding.taxSwitch.setOnCheckedChangeListener { compoundButton, isChecked ->

            if(isChecked){
                binding.taxElements.visibility = View.VISIBLE
            }
            else{
                binding.taxElements.visibility = View.GONE
                binding.taxRate.setText("")
            }

        }

        binding.reinvestmentSwitch.setOnCheckedChangeListener { compoundButton, isChecked ->

            if(isChecked){
                binding.reinvestmentElements.visibility = View.VISIBLE
            }
            else{
                binding.reinvestmentElements.visibility = View.GONE
            }

        }

        binding.addAttSwitch.setOnCheckedChangeListener { compoundButton, isChecked ->

            if(isChecked){
                binding.group1.visibility = View.VISIBLE
            }
            else{
                binding.group1.visibility = View.GONE
                binding.group2.visibility = View.GONE
                binding.group3.visibility = View.GONE
                binding.AdditionalAttachmentsAmount.setText("")
                binding.AdditionalAttachmentsTime.setText("")
            }

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

    private fun showAddAtt() {
        when{
            //groupN необходимо ставить в порядке убывания N

            binding.group2.visibility === View.VISIBLE -> binding.group3.visibility = View.VISIBLE
            binding.group1.visibility === View.VISIBLE -> binding.group2.visibility = View.VISIBLE
        }
    }

    private fun analiticsChanger() {
        if((binding.InitAmount.text.toString() == "") || (binding.textTermNumber.text.toString() == "") || (binding.textRateNumber.text.toString() == "")){
            return
        }

        binding.startAmount.text = binding.InitAmount.text.toString()

        val startAm:Int = binding.InitAmount.text.toString().toInt()
        val term:Int = binding.textTermNumber.text.removeSuffix(" лет").toString().toInt()
        val rate:Int = binding.textRateNumber.text.removeSuffix(" %").toString().toInt()
        var resultAm:Float = startAm.toFloat()

        // рассчет сложного процента
        for(i in 1..term){
            resultAm += (resultAm / 100) * rate
        }

        var incomeAm:Float = resultAm - startAm

        // Вычетание налогов
        if(binding.taxRate.text.toString() != ""){
            resultAm -= (incomeAm/100) * binding.taxRate.text.toString().toInt()
            incomeAm = resultAm - startAm
        }

        binding.incomeAmount.text = incomeAm.toInt().toString()
        binding.resultAmount.text = resultAm.toInt().toString()
    }

}