package com.example.kidzlearn

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class FruitsDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruits_details)

        var fruit = intent.getStringExtra("fruit")!!.lowercase()
        var iid = resources.getIdentifier(fruit, "drawable", packageName)


        var iv = findViewById<ImageView>(R.id.imageView2)
        iv.setImageResource(iid)

        var mid = resources.getIdentifier(fruit, "raw", packageName)
        var mp = MediaPlayer.create(applicationContext, mid)
        mp.start()
    }
}