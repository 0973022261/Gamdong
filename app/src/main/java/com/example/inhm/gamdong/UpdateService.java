package com.example.inhm.gamdong;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

public class UpdateService extends Service {
    public UpdateService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        RemoteViews updateViews = new RemoteViews(this.getPackageName(),R.layout.gam_dong);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
