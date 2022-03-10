package com.example.minichallenge2

import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import jp.wasabeef.blurry.Blurry


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnSkip = findViewById<TextView>(R.id.btnSkip)

        findViewById<ImageView>(R.id.ivBackground).post {
            val bitmap = Blurry.with(this)
                .radius(7)
                .sampling(2)
                .animate(500)
                .capture(findViewById(R.id.ivBackground)).get()
            findViewById<ImageView>(R.id.ivBackground).setImageDrawable(
                BitmapDrawable(
                    resources,
                    bitmap
                )
            )
        }

        btnNext.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        btnSkip.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            Toast.makeText(this,"You Use Skip!", Toast.LENGTH_SHORT).show()
        }

    }

}
