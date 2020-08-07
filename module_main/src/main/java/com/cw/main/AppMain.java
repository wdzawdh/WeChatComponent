package com.cw.main;

import android.content.Context;

import com.cw.common.IAppDelegate;
import com.cw.main.api.IMain;
import com.cw.main.api.MainApi;

import androidx.annotation.Keep;

/**
 * @author Cw
 * @date 2020/8/6
 */
@Keep
public class AppMain implements IAppDelegate {

    private Context context;

    @Override
    public void attachBaseContext(Context base) {
        this.context = base;
        MainApi.register(IMain.class, MainContact.getInstance());
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onTerminate() {

    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onTrimMemory(int level) {

    }
}
