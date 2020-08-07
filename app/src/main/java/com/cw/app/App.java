package com.cw.app;

import android.app.Application;
import android.content.Context;

import com.cw.common.utils.ClassUtils;
import com.cw.common.IAppDelegate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cw
 * @date 2020/8/7
 */
public class App extends Application {

    private List<IAppDelegate> mAppDelegateList = new ArrayList<>();

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mAppDelegateList = ClassUtils.getObjectsWithInterface(this, IAppDelegate.class, base.getPackageName());
        for (IAppDelegate delegate : mAppDelegateList) {
            delegate.attachBaseContext(base);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        for (IAppDelegate delegate : mAppDelegateList) {
            delegate.onCreate();
        }
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
        for (IAppDelegate delegate : mAppDelegateList) {
            delegate.onTerminate();
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        for (IAppDelegate delegate : mAppDelegateList) {
            delegate.onLowMemory();
        }
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        for (IAppDelegate delegate : mAppDelegateList) {
            delegate.onTrimMemory(level);
        }
    }
}
