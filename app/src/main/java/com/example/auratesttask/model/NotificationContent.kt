package com.example.auratesttask.model

import android.content.Context
import com.example.auratesttask.BootCompletedRepository
import com.example.auratesttask.R

class NotificationContent(
    private val repository: BootCompletedRepository,
    private val context: Context
) {

    fun getNotificationContent(): String = if (repository.findReceivedBoots().isEmpty()) {
        context.getString(R.string.notification_no_boot_events)
    } else {
        if (repository.hasSingleBootRecord()) {
            "${context.getString(R.string.notification_single_boot_event)}=${
                repository.findReceivedBoots().first().lastTimeReceived
            }"
        } else {
            "${context.getString(R.string.notification_delta)}=${repository.findBootTimeDiff()}"
        }
    }
}