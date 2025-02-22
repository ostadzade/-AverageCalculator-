package com.example.averagecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // اتصال به عناصر UI
        val number1Input = findViewById<EditText>(R.id.number1)
        val number2Input = findViewById<EditText>(R.id.number2)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        // تنظیم کلیک روی دکمه محاسبه
        calculateButton.setOnClickListener {
            // خواندن مقادیر ورودی
            val number1Text = number1Input.text.toString()
            val number2Text = number2Input.text.toString()

            // بررسی خالی بودن ورودی‌ها
            if (number1Text.isEmpty() || number2Text.isEmpty()) {
                Toast.makeText(this, "لطفاً هر دو عدد را وارد کنید", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // تبدیل ورودی‌ها به اعداد
            val number1 = number1Text.toDoubleOrNull()
            val number2 = number2Text.toDoubleOrNull()

            // بررسی معتبر بودن اعداد
            if (number1 == null || number2 == null) {
                Toast.makeText(this, "لطفاً اعداد معتبر وارد کنید", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // محاسبه میانگین
            val average = (number1 + number2) / 2

            // نمایش نتیجه
            resultTextView.text = "نتیجه: $average"
        }
    }
}