package com.example.services;

import static com.example.services.ChannelClass.ChannelId;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import java.security.Provider;

public class ServiceExample extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent notiIntent= new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notiIntent,0);
        Notification notification = new NotificationCompat.Builder(this,ChannelId)
                .setContentTitle("My notification")
                .setContentText("This is My Notification")
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setContentIntent(pendingIntent).build();

        startForeground(1,notification);
        return START_NOT_STICKY;
    }


}
