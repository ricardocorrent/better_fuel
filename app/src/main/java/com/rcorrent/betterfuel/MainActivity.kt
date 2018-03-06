package com.rcorrent.betterfuel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var ethanolPrice: String
    lateinit var gasolinePrice: String
    lateinit var better: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun valid(priceEth: String, priceGas: String): Boolean {
        return !(priceEth == "" || priceGas == "")
    }

    fun calculate(priceEth: String, priceGas: String): Double{
        return priceEth.toDouble() / priceGas.toDouble()
    }

    fun calculateFuel(view: View){

        ethanolPrice = edtEthanol.text.toString()
        gasolinePrice = edtGasoline.text.toString()

        if(valid(ethanolPrice, gasolinePrice)) {
            if(calculate(ethanolPrice, gasolinePrice) > 0.7){
                better = "Gasoline is better!"
            } else {
                better = "Ethanol is better!"
            }

        }else{
            better = "Set the values!"
        }

        tvDisplay.setText(better)

    }


}
