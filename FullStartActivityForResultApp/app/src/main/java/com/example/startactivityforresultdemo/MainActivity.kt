
package com.example.startactivityforresultdemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val userInput = data?.getStringExtra("user_input")
            tvResult.text = "You entered: $userInput"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)
        val btnOpenSecond = findViewById<Button>(R.id.btnOpenSecondActivity)

        btnOpenSecond.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            resultLauncher.launch(intent)
        }
    }
}
