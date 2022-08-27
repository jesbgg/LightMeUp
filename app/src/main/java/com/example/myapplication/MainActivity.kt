package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.ViewModel


class MainActivity : AppCompatActivity() {

    val imageViewModel : ImageViewModel by viewModels()

    companion object {
        private const val  KEY_IMAGE = "IMAGE"
    }

//    var love = R.drawable.ic_favorite_black_24dp

//    class MainActivity : AppCompatActivity() {
//        private const val KEY_IMAGE = "IMAGE"
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setImageDrawable(AppCompatResources.getDrawable(this, imageViewModel.love))

//        savedInstanceState?.let{
//            love = it.getInt(KEY_IMAGE)
//            imageView.setImageDrawable(getDrawable(love))
//        }

        imageView.setOnClickListener {
            imageViewModel.nextImage()
//            love = when (love) {
//                R.drawable.ic_favorite_black_24dp -> R.drawable.ic_favorite_border_black_24dp
//               R.drawable.ic_favorite_border_black_24dp -> R.drawable.ic_grade_black_24dp
//                R.drawable.ic_grade_black_24dp -> R.drawable.ic_favorite_black_24dp

//                else -> R.drawable.ic_favorite_black_24dp
//            }
//            imageView.setImageDrawable(getDrawable(love))
            imageView.setImageDrawable(getDrawable(imageViewModel.love))
            true
          }
        }

    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putInt(KEY_IMAGE, love)
//    }
//}

class ImageViewModel: ViewModel() {

    var love = R.drawable.ic_favorite_black_24dp

    fun nextImage() {
        love = when (love) {
            R.drawable.ic_favorite_black_24dp -> R.drawable.ic_favorite_border_black_24dp
            R.drawable.ic_favorite_border_black_24dp -> R.drawable.ic_grade_black_24dp
            R.drawable.ic_grade_black_24dp -> R.drawable.ic_favorite_black_24dp
            else -> R.drawable.ic_favorite_black_24dp
        }

    }

}