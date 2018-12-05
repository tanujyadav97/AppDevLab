package com.android.hackslash.lab;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    final Handler handler = new Handler();

    public MyService() {
    }

    @Override
    public void onCreate() {
        handler.post(update);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        handler.removeCallbacks(update);
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Runnable update = new Runnable() {
        @Override
        public void run() {
            Toast.makeText(getBaseContext(), "Service is Running", Toast.LENGTH_SHORT).show();
            handler.postDelayed(this, 2000);
        }
    };
}
