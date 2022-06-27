package com.example.myapplication
import android.annotation.SuppressLint
import android.app.Activity
import net.objecthunter.exp4j.ExpressionBuilder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn7).setOnClickListener{update("7")}
        findViewById<Button>(R.id.btn8).setOnClickListener{update("8")}
        findViewById<Button>(R.id.btn9).setOnClickListener{update("9")}
        findViewById<Button>(R.id.btn4).setOnClickListener{update("4")}
        findViewById<Button>(R.id.btn5).setOnClickListener{update("5")}
        findViewById<Button>(R.id.btn6).setOnClickListener{update("6")}
        findViewById<Button>(R.id.btn1).setOnClickListener{update("1")}
        findViewById<Button>(R.id.btn2).setOnClickListener{update("2")}
        findViewById<Button>(R.id.btn3).setOnClickListener{update("3")}
        findViewById<Button>(R.id.btn0).setOnClickListener { update("0") }
        findViewById<Button>(R.id.btnDot).setOnClickListener { update(".") }
        findViewById<Button>(R.id.btnClr).setOnClickListener { update("isClear") }

        findViewById<Button>(R.id.btnMultiply).setOnClickListener{ update("*") }
        findViewById<Button>(R.id.btnAdd).setOnClickListener{ update("+")}
        findViewById<Button>(R.id.btnDivide).setOnClickListener{update("/")}
        findViewById<Button>(R.id.btnSub).setOnClickListener { update("-") }


        findViewById<Button>(R.id.btnBack).setOnClickListener{
            val expression=findViewById<TextView>(R.id.showScreen).text.toString()
            if(expression.isNotEmpty()){
                findViewById<TextView>(R.id.showScreen).text = expression.substring(0,expression.length - 1)
            }

        }

        findViewById<Button>(R.id.btnAnswer).setOnClickListener {

            try {
                val expression = ExpressionBuilder(findViewById<TextView>(R.id.showScreen).text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {

                    findViewById<TextView>(R.id.showScreen).text = longResult.toString()
                } else
                    findViewById<TextView>(R.id.showScreen).text = result.toString()

            } catch (e: Exception) {
                Log.d("EXCEPTION", "Message: ${e.message}")
            }
        }
    }




    private fun update(string: String) {


        if (string == "isClear") {
            findViewById<TextView>(R.id.showScreen).text = " "
        } else {
            findViewById<TextView>(R.id.showScreen).append(string)
        }

    }
}





