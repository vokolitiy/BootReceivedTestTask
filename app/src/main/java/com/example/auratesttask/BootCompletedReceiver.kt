package com.example.auratesttask

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.auratesttask.model.NotificationContent

class BootCompletedReceiver : BroadcastReceiver() {

    private val repository: BootCompletedRepository by lazy {
        BootCompletedRepository()
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        showNotification(context)
    }

    private fun showNotification(context: Context?) {
        val content = NotificationContent(repository, context!!)
        val notificationManager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val builder = ReceivedBootNotificationBuilder(content).build(context)
        notificationManager.notify(1, builder.build())
    }
}