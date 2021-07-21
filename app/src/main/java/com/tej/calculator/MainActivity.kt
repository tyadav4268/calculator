package com.tej.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.text.HtmlCompat
import com.tej.calculator.databinding.ActivityMainBinding
import kotlin.math.log
import kotlin.math.sqrt

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
        binding.buAC.setOnClickListener { clearAll() }
        binding.backSpaceImageButton.setOnClickListener { backSpace() }
        binding.buPercent.setOnClickListener { percent() }
        binding.buLog.setOnClickListener { findLog() }
        binding.buOneByX.setOnClickListener { findOneByX() }
        binding.buSquare.setOnClickListener { squareIt() }
        binding.buUnderRoot.setOnClickListener { findRoot() }






    }

    private fun squareIt() {
        val inputData = binding.textView.text.toString()
        if(inputData != ""){
            val ans = inputData.toDouble() * inputData.toDouble()
            binding.textView.text = ans.toString()
        }
    }

    private fun findOneByX() {
        val inputData = binding.textView.text.toString()
        if(inputData != ""){
            val ans = 1.0 / inputData.toDouble()
            binding.textView.text = ans.toString()
        }
    }

    private fun findRoot() {
        val inputData = binding.textView.text.toString()
        if(inputData != ""){
            val ans = sqrt(inputData.toDouble())
            binding.textView.text = ans.toString()
        }
    }

    private fun findLog() {
        val inputData = binding.textView.text.toString()
        if(inputData != ""){
            val ans = log(inputData.toDouble(), 2.0)
            binding.textView.text = ans.toString()
        }
    }

    private fun percent() {
        val number = binding.textView.text.toString()
        if(number != "") {
            val newNumber = number.toDouble() / 100
            binding.textView.text = newNumber.toString()
        }

    }

    private fun backSpace() {
        val originalText = binding.textView.text.toString()
        if(originalText != "") {
            val newText = originalText.subSequence(0, originalText.length - 1)
            binding.textView.text = newText
        }
    }

    private fun clearAll() {
        binding.textView.text = ""
        binding.completeCalculation.text = ""
        oldNumber = ""
        ans = 0.0
    }
    var ans = 0.0
    private fun equalsButtonClicked() {
        val newInput = binding.textView.text.toString()
        if(oldNumber != "" && newInput != ""){
            val newNumber = newInput.toDouble()

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
            binding.textView.text = ans.toString()
            binding.completeCalculation.text = getString(R.string.calciDetails, oldNumber, op, newNumber.toString(), "=", ans.toString())
            newOp = true
            oldNumber = ans.toString()
        }

    }

    private var op = ""
    private var oldNumber = ""
    private var newOp = true
    private fun operationButtonClicked(view: View) {
        val buttonSelected = view as Button
        if(oldNumber != "" && !binding.completeCalculation.text.toString().contains("=")) {
            equalsButtonClicked()
        }
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

        oldNumber = binding.textView.text.toString()
        if(oldNumber != "") {
            binding.completeCalculation.text = getString(R.string.calciDetails,oldNumber, op, "", "", "")
            binding.textView.text = ""
            newOp = true

        }
    }

    private fun numberButtonClicked(view: View) {
        if(newOp) {
            binding.textView.text = ""
        }
        newOp = false
        val buSelected = view as Button
        var buClickValue = binding.textView.text.toString()
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
                if(!buClickValue.contains("."))
                    buClickValue += "."
            }
            binding.buPlusMinus.id -> {
                if(buClickValue.startsWith("-"))
                    buClickValue = buClickValue.subSequence(1, buClickValue.length).toString()
                else
                    buClickValue = "-$buClickValue"
            }
        }
        binding.textView.text = buClickValue
    }

}