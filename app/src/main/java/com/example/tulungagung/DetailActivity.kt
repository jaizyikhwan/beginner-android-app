package com.example.tulungagung

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tulungagung.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //TERIMA DATA
        val dataWisata = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Wisata>("key_wisata", Wisata::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Wisata>("key_wisata")
        }

        if (dataWisata != null) {
            binding.nameDetail.text = dataWisata.name
            binding.descriptionDetail.text = dataWisata.description
            binding.imageDetail.setImageResource(dataWisata.photo)
        }

    }
}