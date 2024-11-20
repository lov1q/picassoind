package com.example.picassoind

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private lateinit var nextButton : Button
    private lateinit var imageView : ImageView

    private var currentIndex = 0

    private val imagePaths = mutableListOf(
        "https://i.pinimg.com/736x/2a/91/b6/2a91b650d14116256d21434b09dbca98.jpg",
        "https://i.pinimg.com/originals/4e/ca/cb/4ecacbb84ab60c5fe903de1b1d4f5297.jpg",
        "https://pic.rutubelist.ru/user/4f/0d/4f0dd37df705b4f48bb3895b67a7c826.jpg",
        "https://i.ytimg.com/vi/eUazGODJJio/maxresdefault.jpg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextButton = findViewById(R.id.button)
        imageView = findViewById(R.id.imageView)

        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % imagePaths.size // Циклический переход по индексам
            loadImage()
        }
    }

    private fun loadImage(){
        Picasso.get()
            .load(imagePaths[currentIndex])
            .error(R.drawable.ic_launcher_background)
            .resize(250, 250)
            .into(imageView)
    }
}