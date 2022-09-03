package com.lamaq.calculator

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.Vibrator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColor
import com.lamaq.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val v : Vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        binding.btnAc.setOnClickListener {
            binding.workingsTV.text = ""
            binding.resultsTV.text = ""
            v.vibrate(50)
        }
        binding.btnDel.setOnClickListener {
            binding.workingsTV.text = binding.workingsTV.text.toString().dropLast(1)
            v.vibrate(50)
        }
        binding.btnMod.setOnClickListener {
            binding.workingsTV.append(" % ")
            v.vibrate(50)
            if (binding.resultsTV.text.isNotEmpty()) {
                binding.workingsTV.text = binding.resultsTV.text.toString()
                binding.resultsTV.text = ""
                binding.workingsTV.append(" % ")
            }
        }
        binding.btnDiv.setOnClickListener {
            binding.workingsTV.append(" ÷ ")
            v.vibrate(50)
            if (binding.resultsTV.text.isNotEmpty()) {
                binding.workingsTV.text = binding.resultsTV.text.toString()
                binding.resultsTV.text = ""
                binding.workingsTV.append(" ÷ ")
            }
        }
        binding.btnMult.setOnClickListener {
            binding.workingsTV.append(" × ")
            v.vibrate(50)
            if (binding.resultsTV.text.isNotEmpty()) {
                binding.workingsTV.text = binding.resultsTV.text.toString()
                binding.resultsTV.text = ""
                binding.workingsTV.append(" × ")
            }
        }
        binding.btnSub.setOnClickListener {
            binding.workingsTV.append(" - ")
            v.vibrate(50)
            if (binding.resultsTV.text.isNotEmpty()) {
                binding.workingsTV.text = binding.resultsTV.text.toString()
                binding.resultsTV.text = ""
                binding.workingsTV.append(" - ")
            }
        }
        binding.btnAdd.setOnClickListener {
            binding.workingsTV.append(" + ")
            v.vibrate(50)
            if (binding.resultsTV.text.isNotEmpty()) {
                binding.workingsTV.text = binding.resultsTV.text.toString()
                binding.resultsTV.text = ""
                binding.workingsTV.append(" + ")
            }
        }
        binding.btnEq.setOnClickListener {
            v.vibrate(50)
            val expressionIn =
                binding.workingsTV.text.toString().replace("÷", "/").replace("×", "*")
                    .replace("%", "/100*100")
            try {
                val expressionBuilder = ExpressionBuilder(expressionIn).build()
                val evaluate = expressionBuilder.evaluate()
                val result = evaluate.toLong()

                if (evaluate != result.toDouble()) {
                    binding.resultsTV.text = evaluate.toString()
                } else {
                    binding.resultsTV.text = result.toString()
                }
            } catch (E: Exception) {
                binding.resultsTV.text = "Format Error"
            }

        }
        binding.btnDot.setOnClickListener {
            binding.workingsTV.append(".")
            v.vibrate(50)
        }
        binding.btn0.setOnClickListener {
            binding.workingsTV.append("0")
            v.vibrate(50)
        }
        binding.btn1.setOnClickListener {
            binding.workingsTV.append("1")
            v.vibrate(50)
        }
        binding.btn2.setOnClickListener {
            binding.workingsTV.append("2")
            v.vibrate(50)
        }
        binding.btn3.setOnClickListener {
            binding.workingsTV.append("3")
            v.vibrate(50)
        }
        binding.btn4.setOnClickListener {
            binding.workingsTV.append("4")
            v.vibrate(50)
        }
        binding.btn5.setOnClickListener {
            binding.workingsTV.append("5")
            v.vibrate(50)
        }
        binding.btn6.setOnClickListener {
            binding.workingsTV.append("6")
            v.vibrate(50)
        }
        binding.btn7.setOnClickListener {
            binding.workingsTV.append("7")
            v.vibrate(50)
        }
        binding.btn8.setOnClickListener {
            binding.workingsTV.append("8")
            v.vibrate(50)
        }
        binding.btn9.setOnClickListener {
            binding.workingsTV.append("9")
            v.vibrate(50)
        }
    }
}