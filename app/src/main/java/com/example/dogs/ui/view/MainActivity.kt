package com.example.dogs.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.dogs.databinding.ActivityMainBinding
import com.example.dogs.ui.viewmodel.DogViewModel
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val dogViewModel: DogViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater )
        setContentView(binding.root)

        dogViewModel.onCreate()

        dogViewModel.dog.observe(this){dogModel ->
            for(dog in dogModel){
                for(image in dog.imgUrl){
                    val viewPhoto = ImageView(this)
                    viewPhoto.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                    )
                    Picasso.get().load(image).into(viewPhoto)
                    binding.layoutImages.addView(viewPhoto)
                }
            }
        }

        dogViewModel.isLoading.observe(this){
            binding.progressBar.isVisible = it
        }

    }
}