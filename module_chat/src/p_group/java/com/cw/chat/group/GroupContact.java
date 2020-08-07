package com.cw.chat.group;

import android.content.Context;
import android.content.Intent;

import com.cw.chat.api.IGroup;

/**
 * @author Cw
 * @date 2020/8/6
 */
public class GroupContact implements IGroup {
    private static GroupContact instance;

    private GroupContact() {
    }

    public static GroupContact getInstance() {
        if (instance == null) {
            instance = new GroupContact();
        }
        return instance;
    }

    @Override
    public void openGroupPage(Context context) {
        Intent intent = new Intent(context, GroupActivity.class);
        context.startActivity(intent);
    }
}
