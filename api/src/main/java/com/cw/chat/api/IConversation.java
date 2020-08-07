package com.cw.chat.api;

import android.content.Context;

/**
 * @author Cw
 * @date 2020/8/6
 */
public interface IConversation {
    int getUnreadCount();
    void openConversationPage(Context context);
}
