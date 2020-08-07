package com.cw.chat;

import android.content.Context;

import com.cw.chat.api.ChatApi;
import com.cw.chat.api.IChat;
import com.cw.chat.api.IConversation;
import com.cw.chat.api.IGroup;
import com.cw.chat.conversation.ConversationContact;
import com.cw.chat.group.GroupContact;
import com.cw.common.IAppDelegate;

import androidx.annotation.Keep;

/**
 * @author Cw
 * @date 2020/8/6
 */
@Keep
public class AppChat implements IAppDelegate {

    private Context context;

    @Override
    public void attachBaseContext(Context base) {
        this.context = base;
        ChatApi.register(IChat.class, ChatContact.getInstance());
        ChatApi.register(IConversation.class, ConversationContact.getInstance());
        ChatApi.register(IGroup.class, GroupContact.getInstance());
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
