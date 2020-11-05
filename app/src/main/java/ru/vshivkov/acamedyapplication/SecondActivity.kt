package ru.vshivkov.acamedyapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val buttonForward: Button = findViewById(R.id.buttonForward);
        buttonForward.setOnClickListener { moveToNextScreen() }

        val buttonBack: Button = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener { moveToPreviouslyScreen() }
    }

    private fun moveToNextScreen() {
        val intent = Intent(this, ThirdActivity
        ::class.java);
        startActivity(intent);
    }

    private fun moveToPreviouslyScreen() {
        val intent = Intent(this, MainActivity::class.java);
        startActivity(intent);
    }
}