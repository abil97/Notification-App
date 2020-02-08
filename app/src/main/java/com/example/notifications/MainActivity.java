package com.example.notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notifiactionManager;
    private EditText title, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notifiactionManager = NotificationManagerCompat.from(this);
        title = findViewById(R.id.editText);
        message = findViewById(R.id.editText2);

    }

    public void sendNotification(View v){
        Notification notification = new NotificationCompat.Builder(this, App.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_mood_black_24dp)
                .setContentTitle(title.getText().toString())
                .setContentText(message.getText().toString())
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(new long[] {1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000})
                .setSound(Uri.parse("android.resource://"
                        + this.getPackageName() + "/" + R.raw.ios_notification))
                .build();


        notifiactionManager.notify(1, notification);
    }


}
