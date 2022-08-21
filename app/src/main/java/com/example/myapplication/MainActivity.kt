package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    var love = R.drawable.ic_favorite_black_24dp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setOnClickListener {
            love = when (love) {
                R.drawable.ic_favorite_black_24dp -> R.drawable.ic_favorite_border_black_24dp
                R.drawable.ic_favorite_border_black_24dp -> R.drawable.ic_favorite_black_24dp
                else -> R.drawable.ic_favorite_black_24dp
            }
            imageView.setImageDrawable(getDrawable(love))
        }

    }
}