package com.saif.calculator

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var number1: Float = 0.0F
    private var isPlus: Boolean = false
    private var isSub: Boolean = false
    private var isDiv: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        screen.text = "0"

        btn_1.setOnClickListener(this)
        btn_2.setOnClickListener(this)
        btn_3.setOnClickListener(this)
        btn_4.setOnClickListener(this)
        btn_5.setOnClickListener(this)
        btn_6.setOnClickListener(this)
        btn_7.setOnClickListener(this)
        btn_8.setOnClickListener(this)
        btn_9.setOnClickListener(this)
        btn_plus.setOnClickListener(this)
        btn_sub.setOnClickListener(this)
        btn_equal.setOnClickListener(this)
        btn_0.setOnClickListener(this)
        btn_div.setOnClickListener(this)
        btn_C.setOnClickListener(this)
        btn_dot.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_1 -> numbersClicked(1)
            R.id.btn_2 -> numbersClicked(2)
            R.id.btn_3 -> numbersClicked(3)
            R.id.btn_4 -> numbersClicked(4)
            R.id.btn_5 -> numbersClicked(5)
            R.id.btn_6 -> numbersClicked(6)
            R.id.btn_7 -> numbersClicked(7)
            R.id.btn_8 -> numbersClicked(8)
            R.id.btn_9 -> numbersClicked(9)
            R.id.btn_0 -> numbersClicked(0)
            R.id.btn_C -> screen.text = ""
            R.id.btn_dot -> {
                val number2 = screen.text.toString() + "."
                if (!screen.text.contains(".")) {
                    screen.text = number2
                }
            }
            R.id.btn_plus -> add()
            R.id.btn_sub -> subtract()
            R.id.btn_div -> division()
            R.id.btn_equal -> equalCalled()
        }
    }

    private fun equalCalled() {
        when {
            isPlus -> {
                val number2 = screen.text.toString().toFloat()
                val result = number1 + number2
                screen.text = result.toString()
                isPlus = false
            }
            isSub -> {
                val number2 = screen.text.toString().toFloat()
                val result = number1 - number2
                screen.text = result.toString()
                isSub = false
            }
            isDiv -> {
                val number2 = screen.text.toString().toFloat()
                val result = number1 / number2
                screen.text = result.toString()
                isDiv = false
            }
        }
    }

    private fun division() {
        try {
            number1 = screen.text.toString().toFloat()
            screen.text = ""
            isDiv = true
        }catch (e: Exception){
            Toast.makeText(this,"put number first", Toast.LENGTH_SHORT).show()
        }
    }

    private fun subtract() {
        try {
            number1 = screen.text.toString().toFloat()
            screen.text = ""
            isSub = true
        }catch (e: Exception){
            Toast.makeText(this,"put number first", Toast.LENGTH_SHORT).show()
        }
    }

    private fun add() {
        try {
            number1 = screen.text.toString().toFloat()
            screen.text = ""
            isPlus = true
        }catch (e: Exception){
            Toast.makeText(this,"put number first", Toast.LENGTH_SHORT).show()
        }
    }

    private fun numbersClicked(num: Int) {
        val number = screen.text.toString() + num.toString()
        screen.text = number
    }

}