package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView


class MainActivity : AppCompatActivity() {

    companion object {
        private const val  KEY_IMAGE = "IMAGE"
    }

    var love = R.drawable.ic_favorite_black_24dp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)

        savedInstanceState?.let{
            love = it.getInt(KEY_IMAGE)
            imageView.setImageDrawable(getDrawable(love))
        }

        imageView.setOnClickListener {
            love = when (love) {
                R.drawable.ic_favorite_black_24dp -> R.drawable.ic_favorite_border_black_24dp
                R.drawable.ic_favorite_border_black_24dp -> R.drawable.ic_favorite_black_24dp
                else -> R.drawable.ic_favorite_black_24dp
            }
            imageView.setImageDrawable(getDrawable(love))
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_IMAGE, love)
    }
}