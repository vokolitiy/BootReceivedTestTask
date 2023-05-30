package com.example.auratesttask

import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.auratesttask.model.NotificationContent

class ReceivedBootNotificationBuilder(private val notificationContent: NotificationContent) {

    fun build(context: Context): NotificationCompat.Builder {
        val flag = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            PendingIntent.FLAG_IMMUTABLE
        } else {
            PendingIntent.FLAG_UPDATE_CURRENT
        }
        val contentIntent = PendingIntent.getActivity(context, 0, Intent(context, MainActivity::class.java),
            flag)
        return NotificationCompat.Builder(context, channelId).apply {
            setSmallIcon(0)
            setContentTitle(context.getString(R.string.notification_title))
            setContentText(notificationContent.getNotificationContent())
            setContentIntent(contentIntent)
            setDefaults(Notification.DEFAULT_SOUND)
            setAutoCancel(true)
        }
    }

    private companion object {
        const val channelId: String = "BOOT_RECEICED_CHANNEL_ID"
    }
}