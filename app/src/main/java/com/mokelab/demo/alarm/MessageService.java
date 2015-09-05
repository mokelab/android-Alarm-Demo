package com.mokelab.demo.alarm;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Service for Message
 */
public class MessageService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String text = intent.getStringExtra(Intent.EXTRA_TEXT);

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        return Service.START_NOT_STICKY;
    }
}
