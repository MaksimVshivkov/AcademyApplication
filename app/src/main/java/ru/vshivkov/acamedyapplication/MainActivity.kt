package ru.vshivkov.acamedyapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), FragmentMoviesDetails.ClickListener {

    private val fragmentMoviesList = FragmentMoviesList();
    private val fragmentMoviesDetails = FragmentMoviesDetails()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.fragments_container, fragmentMoviesList)
                commit()
            }
    }

    override fun goBack() {
        supportFragmentManager.beginTransaction()
            .apply {
                remove(fragmentMoviesDetails)
                replace(R.id.fragments_container, fragmentMoviesList)
                commit()
            }
    }

    override fun openDetails() {
        supportFragmentManager.beginTransaction()
            .apply {
                remove(fragmentMoviesList)
                replace(R.id.fragments_container, fragmentMoviesDetails)
                commit()
            }
    }

}