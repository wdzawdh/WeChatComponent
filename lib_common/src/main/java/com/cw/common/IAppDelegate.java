package com.cw.common;

import android.content.Context;

public interface IAppDelegate {

    void attachBaseContext(Context base);

    void onCreate();

    void onTerminate();

    void onLowMemory();

    void onTrimMemory(int level);
}
