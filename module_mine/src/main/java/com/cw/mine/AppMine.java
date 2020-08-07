package com.cw.mine;

import android.content.Context;

import com.cw.common.IAppDelegate;
import com.cw.mine.api.IMine;
import com.cw.mine.api.IPay;
import com.cw.mine.api.ISetting;
import com.cw.mine.api.MineApi;
import com.cw.mine.pay.PayContact;
import com.cw.mine.setting.SettingContact;

import androidx.annotation.Keep;

/**
 * @author Cw
 * @date 2020/8/6
 */
@Keep
public class AppMine implements IAppDelegate {

    private Context context;

    @Override
    public void attachBaseContext(Context base) {
        this.context = base;
        MineApi.register(IMine.class, MineContact.getInstance());
        MineApi.register(IPay.class, PayContact.getInstance());
        MineApi.register(ISetting.class, SettingContact.getInstance());
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
