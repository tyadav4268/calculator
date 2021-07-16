package com.tej.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.text.HtmlCompat
import com.tej.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buUnderRoot.text = HtmlCompat.fromHtml("&radic;x", HtmlCompat.FROM_HTML_MODE_LEGACY)
        binding.buSquare.text = HtmlCompat.fromHtml("X<sup>2</sup>", HtmlCompat.FROM_HTML_MODE_LEGACY)
        binding.buLog.text = HtmlCompat.fromHtml("log<sub>2</sub>x", HtmlCompat.FROM_HTML_MODE_LEGACY)

        binding.bu0.setOnClickListener{numberButtonClicked(it)}
        binding.bu1.setOnClickListener{numberButtonClicked(it)}
        binding.bu2.setOnClickListener{numberButtonClicked(it)}
        binding.bu3.setOnClickListener{numberButtonClicked(it)}
        binding.bu4.setOnClickListener{numberButtonClicked(it)}
        binding.bu5.setOnClickListener{numberButtonClicked(it)}
        binding.bu6.setOnClickListener{numberButtonClicked(it)}
        binding.bu7.setOnClickListener{numberButtonClicked(it)}
        binding.bu8.setOnClickListener{numberButtonClicked(it)}
        binding.bu9.setOnClickListener{numberButtonClicked(it)}
        binding.buDot.setOnClickListener{numberButtonClicked(it)}
        binding.buPlusMinus.setOnClickListener{numberButtonClicked(it)}
        binding.buPlus.setOnClickListener { operationButtonClicked(it) }
        binding.buMinus.setOnClickListener { operationButtonClicked(it) }
        binding.buMultiply.setOnClickListener { operationButtonClicked(it) }
        binding.buDivide.setOnClickListener { operationButtonClicked(it) }
        binding.buEquals.setOnClickListener { equalsButtonClicked() }






    }

    private fun equalsButtonClicked() {

        val newNumber = binding.inputOuput.text.toString().toDouble()
        var ans = 0.0
        when(op) {
            "+" -> {
                ans = oldNumber.toDouble() + newNumber
            }
            "-" -> {
                ans = oldNumber.toDouble() - newNumber
            }
            "*" -> {
                ans = oldNumber.toDouble() * newNumber
            }
            "/" -> {
                ans = oldNumber.toDouble() / newNumber
            }
        }
        binding.inputOuput.text = ans.toString()
        binding.calciDetails.text = getString(R.string.calciDetails, oldNumber, op, newNumber.toString(), "=", ans.toString())
        newOp = true

    }

    private var op = "+"
    private var oldNumber = ""
    private var newOp = true
    private fun operationButtonClicked(view: View) {
        val buttonSelected = view as Button
        when(buttonSelected.id) {
            binding.buPlus.id -> {
                op = "+"
            }
            binding.buMinus.id -> {
                op = "-"
            }
            binding.buMultiply.id -> {
                op = "*"
            }
            binding.buDivide.id -> {
                op = "/"
            }
        }
        oldNumber = binding.inputOuput.text.toString()
        binding.calciDetails.text = getString(R.string.calciDetails,oldNumber, op, "", "", "")
        binding.inputOuput.text = ""
        newOp = true

    }

    private fun numberButtonClicked(view: View) {
        if(newOp) {
            binding.inputOuput.text = ""
        }
        newOp = false
        val buSelected = view as Button
        var buClickValue = binding.inputOuput.text.toString()
        when(buSelected.id) {
            binding.bu0.id -> {
                buClickValue += "0"
            }
            binding.bu1.id -> {
                buClickValue += "1"
            }
            binding.bu2.id -> {
                buClickValue += "2"
            }
            binding.bu3.id -> {
                buClickValue += "3"
            }
            binding.bu4.id -> {
                buClickValue += "4"
            }
            binding.bu5.id -> {
                buClickValue += "5"
            }
            binding.bu6.id -> {
                buClickValue += "6"
            }
            binding.bu7.id -> {
                buClickValue += "7"
            }
            binding.bu8.id -> {
                buClickValue += "8"
            }
            binding.bu9.id -> {
                buClickValue += "9"
            }
            binding.buDot.id -> {
                buClickValue += "."
            }
            binding.buPlusMinus.id -> {
                buClickValue = "-$buClickValue"
            }
        }
        binding.inputOuput.text = buClickValue
    }

}