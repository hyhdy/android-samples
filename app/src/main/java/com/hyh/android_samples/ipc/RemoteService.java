package com.hyh.android_samples.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

public class RemoteService extends Service {
    private Binder mBinder = new ICalculator.Stub() {
        @Override
        public int add(int a, int b) throws RemoteException {
            Log.d("hyh","RemoteService: add: pid="+android.os.Process.myPid());
            return a + b;
        }
    };

    @Override
    public void onCreate() {
        Log.d("hyh","RemoteService: onCreate: ");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("hyh","RemoteService: onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("hyh","RemoteService: onBind: ");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("hyh","RemoteService: onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d("hyh","RemoteService: onDestroy: ");
        super.onDestroy();
    }
}
