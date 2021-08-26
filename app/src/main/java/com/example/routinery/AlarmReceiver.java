package com.example.routinery;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.EditText;

public class AlarmReceiver extends BroadcastReceiver {
    private EditText PersonName;
    private EditText EndDate;
    @Override
    public void onReceive(Context context, Intent intent) {
        //Get id & message from intent
        int notificationId1 = intent.getIntExtra("notificationId", 0);
        String message = intent.getStringExtra("todo");
        //when notification is tapped, call MainActivity.
        Intent mainIntent = new Intent(context, Home1.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, mainIntent, 0);


        NotificationManager myNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        //prepare Notification
        Notification.Builder builder = new Notification.Builder(context);
        builder.setSmallIcon(android.R.drawable.ic_dialog_info).setContentTitle("It is time!")
                .setContentTitle(message)

                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentIntent(contentIntent)
        .setPriority(Notification.PRIORITY_MAX)
        .setDefaults(Notification.DEFAULT_ALL);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            String channelId = "Your_channel_id";
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_HIGH);
            myNotificationManager.createNotificationChannel(channel);
            builder.setChannelId(channelId);
        }

        //notify
        myNotificationManager.notify(notificationId1, builder.build());


    }
}
