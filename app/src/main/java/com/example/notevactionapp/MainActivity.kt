package com.example.notevactionapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.notevactionapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val notificationId = 1234
    private val channelId = "myapp.notifications"
    private val description = "Notification App Example"


    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder

    lateinit var btnNotification: Button
    lateinit var etNotification: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        etNotification = findViewById(R.id.editTextTextPersonName)
        btnNotification = findViewById(R.id.button)

        btnNotification.setOnClickListener{
            val intent = Intent(this, NotificationActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel = NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
                notificationManager.createNotificationChannel(notificationChannel)

                builder = Notification.Builder(this, channelId)
                    .setSmallIcon(R.drawable.ic_notification)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_notification))
                    .setContentIntent(pendingIntent)
                    .setContentTitle("My Notification")
                    .setContentText(etNotification.text!!)
            } else {

                builder = Notification.Builder(this)
                    .setSmallIcon(R.drawable.ic_notification)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_notification))
                    .setContentIntent(pendingIntent)
                    .setContentTitle("My Notification")
                    .setContentText(etNotification.text!!)
            }
            //executing the notification
            notificationManager.notify(notificationId, builder.build())

        }
    }
}