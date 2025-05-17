package com.example.intentdemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val returnBtn = findViewById<Button>(R.id.buttonReturnResult)
        returnBtn.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("resultKey", "Data from ResultActivity")
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}