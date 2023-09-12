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
                notReadyWarning()
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

            binding.group2.visibility === View.VISIBLE -> binding.group3.visibility = View.VISIBLE
            binding.group1.visibility === View.VISIBLE -> binding.group2.visibility = View.VISIBLE
        }
    }

    private fun notReadyWarning(){
        Toast.makeText(applicationContext, "Раздел в разработке, ввод данных не повлияет на результат", Toast.LENGTH_LONG).show()
    }

    private fun notEnoughData(){
        Toast.makeText(applicationContext, "Не все данные введены", Toast.LENGTH_SHORT).show()
    }

    private fun analiticsChanger() {

        // Проверка введены ли все минимальные необходимые данные P.S. Убрать проверки в отдельную функцию
        if((binding.InitAmount.text.toString() == "") ||
            (binding.textTermNumber.text.toString() == "") ||
            (binding.textRateNumber.text.toString() == ""))
        {
            notEnoughData()
            return
        }

        var AddAtt1Permission: Boolean = false
        var AdditionalAttachments1Time: Int = 0
        var AdditionalAttachment1Amount: Int = 0

        if(binding.addAttSwitch.isChecked) {
            if ((binding.AdditionalAttachments1Time.text.toString() == "") || (binding.AdditionalAttachments1Amount.text.toString() == ""))
            {
                notEnoughData()
                return
            } else {
                AdditionalAttachments1Time =
                    binding.AdditionalAttachments1Time.text.toString().toInt()
                AdditionalAttachment1Amount =
                    binding.AdditionalAttachments1Amount.text.toString().toInt()
                AddAtt1Permission = true
            }
        }

        val startAm: Int = binding.InitAmount.text.toString().toInt()
        val term: Int = binding.textTermNumber.text.removeSuffix(" лет").toString().toInt()
        val rate: Int = binding.textRateNumber.text.removeSuffix(" %").toString().toInt()
        var resultAm: Float = startAm.toFloat()


        // рассчет сложного процента
        var AdditionalAttachments1TimeCounter: Int = 1

        for(i in 1..term){
            if( AddAtt1Permission && (AdditionalAttachments1TimeCounter <= AdditionalAttachments1Time) ){
                resultAm += AdditionalAttachment1Amount
                AdditionalAttachments1TimeCounter += 1
            }
            resultAm += (resultAm / 100) * rate
        }
        AddAtt1Permission = false

        // исправить с доп вложениями
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