package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    // Channel ID and Name (Change these to match your app)
    private static final String CHANNEL_ID = "my_channel_id";
    private static final String CHANNEL_NAME = "My Channel";
    private static final int NOTIFICATION_ID = 1;  // Unique ID for the notification

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the notification channel
        createNotificationChannel();
    }

    // Create the notification channel method (same as before)

    public void onShowNotificationClick(View view) {
        sendNotification("Initial Notification", "This is the initial notification.");
    }

    public void onUpdateNotificationClick(View view) {
        // Call the sendNotification method with updated content
        sendNotification("Updated Notification", "This is the updated notification content.");
    }

    private void sendNotification(String title, String content) {
        // Create an Intent for the action
        Intent detailsIntent = new Intent(this, DetailsActivity.class);
        detailsIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent detailsPendingIntent = PendingIntent.getActivity(
                this,
                0,
                detailsIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        // Create a notification builder with the action
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_noti)
                .setContentTitle(title)
                .setContentText(content)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .addAction(R.drawable.ic_noti, "View Details", detailsPendingIntent);

        // Get the notification manager
        NotificationManager notificationManager = getSystemService(NotificationManager.class);

        // Display the notification
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

}
