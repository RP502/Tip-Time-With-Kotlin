package com.example.tiptime

import android.icu.text.NumberFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addEvents()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun addEvents() {
        btnCalculate.setOnClickListener{
            calculateTip()
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun calculateTip() {
        val cost = edtCost.text.toString().toDoubleOrNull()

        if (cost == null){
            txtTipAmount.text =""
            return
        }
        val tipOption = when (tip_Options.checkedRadioButtonId){
            R.id.rdaAmazing -> 0.20
            R.id.rdaGood -> 0.18
            else -> 0.15
        }
         var tip = cost * tipOption
        if (swRoundTip.isChecked){
            tip = kotlin.math.ceil(tip)
        }
        txtTipAmount.setText(tip.toString())

    }
}