
package com.example.startactivityforresultdemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val etInput = findViewById<EditText>(R.id.etInput)
        val btnSendBack = findViewById<Button>(R.id.btnSendBack)

        btnSendBack.setOnClickListener {
            val inputText = etInput.text.toString().trim()

            if (inputText.isEmpty()) {
                etInput.error = "Field cannot be empty"
                return@setOnClickListener
            }

            val resultIntent = Intent()
            resultIntent.putExtra("user_input", inputText)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
