package com.example.liuyi.learnservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Binder;
import android.telecom.Call;

public class MyService extends Service {

    private boolean isRunning = false;
    protected String data;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return new MyBinder();
    }

    public class MyBinder extends Binder {

        public String getData() {
            return MyService.this.data;
        }

        public void setData(String data) {
            MyService.this.data = data;
        }

        public MyService getService() {
            return MyService.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("service on Command");
        //外界startService后调用
        data = intent.getStringExtra("data");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("service create");
        isRunning = true;
        new Thread() {
            @Override
            public void run() {
                super.run();
                int i = 0;
                while (isRunning) {
                    String data = "data: " + i++;
                    System.out.println(data);
                    if (callback != null) {
                        callback.onDataChanged(data);
                    }
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isRunning = false;
        System.out.println("service onDestroy");
    }

    private Callback callback = null;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public Callback getCallback() {
        return callback;
    }

    public static interface Callback {
        public void onDataChanged(String data);
    }
}
