package ru.vshivkov.acamedyapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val buttonBack: Button = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener { moveToPreviouslyScreen() }

        val buttonOpenMainActivity: Button = findViewById(R.id.buttonOpenMainActivity);
        buttonOpenMainActivity.setOnClickListener { moveToMainScreen() }
    }

    private fun moveToPreviouslyScreen() {
        val intent = Intent(this, SecondActivity::class.java);
        startActivity(intent);
    }

    private fun moveToMainScreen() {
        val intent = Intent(this, MainActivity::class.java);
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent);

    }
}