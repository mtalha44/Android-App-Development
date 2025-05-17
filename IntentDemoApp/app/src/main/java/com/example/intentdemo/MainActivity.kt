package com.example.intentdemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputField = findViewById<EditText>(R.id.editTextInput)
        val goToSecondBtn = findViewById<Button>(R.id.buttonGoToSecond)
        val openWebBtn = findViewById<Button>(R.id.buttonOpenWeb)
        val shareTextBtn = findViewById<Button>(R.id.buttonShareText)

        goToSecondBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("userInput", inputField.text.toString())
            startActivity(intent)
        }

        openWebBtn.setOnClickListener {
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.example.com"))
            startActivity(webIntent)
        }

        shareTextBtn.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Check out this cool app!")
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }
    }
}