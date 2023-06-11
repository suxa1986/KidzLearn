package com.example.kidzlearn

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class AlphabetsDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabets_details)

        var name = intent.getStringExtra("alpha")!!.lowercase()
        Toast.makeText(applicationContext, name, Toast.LENGTH_LONG).show()

        var iid = resources.getIdentifier(name, "drawable", packageName)
        var iv = findViewById<ImageView>(R.id.imageView)
        iv.setImageResource(iid)

        var mid = resources.getIdentifier(name, "raw", packageName)
        var mp = MediaPlayer.create(applicationContext, mid)
        mp.start()
    }
}