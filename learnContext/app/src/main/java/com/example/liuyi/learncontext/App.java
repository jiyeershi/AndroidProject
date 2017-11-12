package com.example.liuyi.learncontext;

import android.app.Application;
import android.content.res.Configuration;

/**
 * Created by liuyi on 16/5/29.
 */
public class App extends Application {


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private String data = "default";

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("app onCreate");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        System.out.println("App onTerminate");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.out.println("App conLowMemory");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        System.out.println("APP onTrimMemory");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        System.out.println("App onConfiguration");
    }
}
