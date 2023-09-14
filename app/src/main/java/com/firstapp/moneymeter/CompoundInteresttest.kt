package com.firstapp.moneymeter

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.firstapp.moneymeter.databinding.CompoundinteresttestBinding

class CompoundInteresttest: AppCompatActivity() {

    lateinit var binding: CompoundinteresttestBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = CompoundinteresttestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val notReadyWarning = Toast.makeText(applicationContext, "Раздел в разработке, данные не повлияют на результат", Toast.LENGTH_LONG)

        with(binding){
            group1.visibility = View.GONE
            group2.visibility = View.GONE
            group3.visibility = View.GONE
            taxElements.visibility = View.GONE
            reinvestmentElements.visibility = View.GONE
        }

        binding.termSlider.addOnChangeListener { slider, value, fromUser ->
            binding.textTermNumber.text = value.toInt().toString() + " лет"
        }

        binding.rateSlider.addOnChangeListener { slider, value, fromUser ->
            binding.textRateNumber.text = value.toInt().toString() + " %"
        }

        binding.plusButton.setOnClickListener {
            showAddAtt()
            notReadyWarning.cancel()
            notReadyWarning.show()
        }

        binding.calcButton.setOnClickListener{
            analiticsChanger()
        }

        binding.cross2.setOnClickListener{
            binding.group2.visibility = View.GONE
            binding.AdditionalAttachments2Amount.setText("")
            binding.AdditionalAttachments2Time.setText("")
        }

        binding.cross3.setOnClickListener{
            binding.group3.visibility = View.GONE
            binding.AdditionalAttachments3Amount.setText("")
            binding.AdditionalAttachments3Time.setText("")
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

                //отчистка данных в блоках доп вложений
                with(binding){
                    AdditionalAttachments1Amount.setText("")
                    AdditionalAttachments1Time.setText("")

                    AdditionalAttachments2Amount.setText("")
                    AdditionalAttachments2Time.setText("")

                    AdditionalAttachments3Amount.setText("")
                    AdditionalAttachments3Time.setText("")
                }
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

    // логика кнопки добавления доп вложений
    private fun showAddAtt() {
        when{
            //groupN необходимо ставить в порядке убывания N

            binding.group2.visibility == View.VISIBLE -> binding.group3.visibility = View.VISIBLE
            binding.group1.visibility == View.VISIBLE -> binding.group2.visibility = View.VISIBLE
        }
    }

    private fun notEnoughData(){
        Toast.makeText(applicationContext, "Не все данные введены", Toast.LENGTH_SHORT).show()
    }

    private fun analiticsChanger() {

        if (!minimalDataCheck()) {
            notEnoughData()
            return
        }

        val startAm: Int = binding.InitAmount.text.toString().toInt()
        val term: Int = binding.textTermNumber.text.removeSuffix(" лет").toString().toInt()
        val rate: Int = binding.textRateNumber.text.removeSuffix(" %").toString().toInt()
        var resultAm: Float = startAm.toFloat()

        var AddAtt1Permission: Boolean = false
        var AddAtt1Time: Int = 0
        var AddAtt1Amount: Int = 0
        var AddAtt1Sum: Int = 0

        if(binding.addAttSwitch.isChecked) {
            if (!minimalAddAtt1DataCheck())
            {
                notEnoughData()
                return
            } else {
                AddAtt1Time = binding.AdditionalAttachments1Time.text.toString().toInt()
                AddAtt1Amount = binding.AdditionalAttachments1Amount.text.toString().toInt()
                AddAtt1Sum = AddAtt1Amount * ( if(term > AddAtt1Time) AddAtt1Time  else term )      // сумма всех доп вложений (пока только при доп вложениях раз в год)
                AddAtt1Permission = true
            }
        }

        // рассчет сложного процента  с доп вложениями раз в год
        var AddAtt1TimeCounter: Int = 1

        for(i in 1..term){
            if( AddAtt1Permission && (AddAtt1TimeCounter <= AddAtt1Time) ){
                resultAm += AddAtt1Amount
                AddAtt1TimeCounter += 1
            }
            resultAm += (resultAm / 100) * rate
        }
        AddAtt1Permission = false

        // исправить с доп вложениями
        var incomeAm:Float = resultAm - startAm - AddAtt1Sum

        // Вычетание налогов (только в конце инвестирования) P.S. добавить на каждый год
        if(binding.taxRate.text.toString() != ""){
            resultAm -= (incomeAm/100) * binding.taxRate.text.toString().toInt()
            incomeAm = resultAm - startAm - AddAtt1Sum
        }

        binding.incomeAmount.text = incomeAm.toInt().toString()
        binding.resultAmount.text = resultAm.toInt().toString()
    }

    private fun minimalDataCheck(): Boolean{
        if((binding.InitAmount.text.toString() == "") ||
           (binding.textTermNumber.text.toString() == "") ||
           (binding.textRateNumber.text.toString() == ""))
        {
            return false
        }
        return true
    }
    private fun minimalAddAtt1DataCheck(): Boolean{
        if ((binding.AdditionalAttachments1Time.text.toString() == "") || (binding.AdditionalAttachments1Amount.text.toString() == "")) {
            return false
        }
        return true
    }
}