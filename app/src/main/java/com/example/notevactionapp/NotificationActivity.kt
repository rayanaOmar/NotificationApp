package com.example.notevactionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notevactionapp.databinding.ActivityNotificationBinding


class NotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}