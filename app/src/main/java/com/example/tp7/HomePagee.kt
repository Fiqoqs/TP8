package com.example.tp7

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class HomePagee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_pagee)

        supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this,R.color.blue)))

        // Ambil TextView untuk username
        val tvUsername: TextView = findViewById(R.id.tv_username)

        // Dapatkan Intent dari Login Fragment
        val username = intent.getStringExtra("USERNAME")

        // Tampilkan username jika ada
        if (!username.isNullOrEmpty()) {
            tvUsername.text = username

            // Temukan tombol berdasarkan ID mereka
            val btnSad: ImageButton = findViewById(R.id.sedih)
            val btnHappy: ImageButton = findViewById(R.id.senang)

            // Set OnClickListener untuk tombol Sad
            btnSad.setOnClickListener {
                // Tampilkan notifikasi Toast
                Toast.makeText(this, "Kamu sedang merasa sedih:(", Toast.LENGTH_SHORT).show()
            }

            // Set OnClickListener untuk tombol Happy
            btnHappy.setOnClickListener {
                // Tampilkan notifikasi Toast
                Toast.makeText(this, "Kamu sedang merasa senang:)", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
