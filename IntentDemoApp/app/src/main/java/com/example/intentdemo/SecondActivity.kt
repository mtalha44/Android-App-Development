package com.example.intentdemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val receivedText = intent.getStringExtra("userInput")
        val textView = findViewById<TextView>(R.id.textViewReceived)
        textView.text = "Received: $receivedText"

        val resultBtn = findViewById<Button>(R.id.buttonSendResult)
        resultBtn.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            resultLauncher.launch(intent)
        }
    }

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val returnedResult = result.data?.getStringExtra("resultKey")
            val resultTextView = findViewById<TextView>(R.id.textViewResult)
            resultTextView.text = "Result: $returnedResult"
        }
    }
}