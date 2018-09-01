package com.phanluongha.mockserverlogin;

import android.app.Application;

import com.phanluongha.mockserverlogin.dragger.components.AppComponent;
import com.phanluongha.mockserverlogin.dragger.components.DaggerAppComponent;
import com.phanluongha.mockserverlogin.dragger.modules.NetworkModule;

public class MockServerApplication extends Application {
    private static MockServerApplication instance;

    public static MockServerApplication getInstance() {
        return instance;
    }

    public static void setInstance(MockServerApplication instance) {
        MockServerApplication.instance = instance;
    }

    private AppComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setInstance(this);

        applicationComponent = DaggerAppComponent.create();
    }

    public AppComponent getApplicationComponent() {
        return applicationComponent;
    }
}
