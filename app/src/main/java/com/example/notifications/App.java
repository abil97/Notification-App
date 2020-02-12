package com.example.notifications;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;

public class App extends Application {

    public static final String CHANNEL_ID = "Channel_id";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        // In other words, this code will work only if Android version is >= Oreo
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {


            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Main Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            Uri uri = Uri.parse("android.resource://"+ this.getPackageName()+"/" + R.raw.ios_notification);

            AudioAttributes att = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                    .build();

            channel.enableVibration(true);
            channel.setDescription("Main channel for the Notification");
            channel.setVibrationPattern(new long[] {0, 500, 500, 500});
            channel.setSound(uri, att);

            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
