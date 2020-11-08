package ru.vshivkov.acamedyapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.vshivkov.acamedyapplication.fragments.FragmentOne
import ru.vshivkov.acamedyapplication.fragments.FragmentSecond
import ru.vshivkov.acamedyapplication.fragments.FragmentThird

class MainActivity : AppCompatActivity() {

    private var countChangeFragment: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonOpenFragmentOne: Button = findViewById(R.id.buttonOpenFragmentOne);
        buttonOpenFragmentOne.setOnClickListener { changeFragmentContent(FragmentOne()) }

        val buttonOpenFragmentTwo: Button = findViewById(R.id.buttonOpenFragmentTwo);
        buttonOpenFragmentTwo.setOnClickListener { changeFragmentContent(FragmentSecond()) }

        val buttonOpenFragmentThree: Button = findViewById(R.id.buttonOpenFragmentThree);
        buttonOpenFragmentThree.setOnClickListener { changeFragmentContent(FragmentThird()) }
    }

    private fun changeFragmentContent(fragment: Fragment) {
        val bundle = Bundle()
        bundle.putString("param1", countChangeFragment.toString())
        bundle.putString("param2", "text param 2")
        fragment.arguments = bundle

        val transaction = supportFragmentManager.beginTransaction()
        if (countChangeFragment == 0) {
            transaction.add(R.id.frame_layout, fragment)
        } else {
            transaction.replace(R.id.frame_layout, fragment)
        }
        transaction.addToBackStack(null)
        transaction.commit()

        countChangeFragment++;
    }
}