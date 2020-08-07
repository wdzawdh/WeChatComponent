package com.cw.mine.setting;

import android.content.Context;
import android.content.Intent;

import com.cw.mine.api.ISetting;

/**
 * @author Cw
 * @date 2020/8/6
 */
public class SettingContact implements ISetting {

    private static SettingContact instance;

    private SettingContact() {
    }

    public static SettingContact getInstance() {
        if (instance == null) {
            instance = new SettingContact();
        }
        return instance;
    }

    @Override
    public void openSettingPage(Context context) {
        Intent intent = new Intent(context, SettingActivity.class);
        context.startActivity(intent);
    }
}
