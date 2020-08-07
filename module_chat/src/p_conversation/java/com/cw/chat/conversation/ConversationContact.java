package com.cw.chat.conversation;

import android.content.Context;
import android.content.Intent;

import com.cw.chat.api.IConversation;

/**
 * @author Cw
 * @date 2020/8/6
 */
public class ConversationContact implements IConversation {

    private static ConversationContact instance;

    private ConversationContact() {
    }

    public static ConversationContact getInstance() {
        if (instance == null) {
            instance = new ConversationContact();
        }
        return instance;
    }

    @Override
    public int getUnreadCount() {
        return 99;
    }

    @Override
    public void openConversationPage(Context context) {
        Intent intent = new Intent(context, ConversationActivity.class);
        context.startActivity(intent);
    }
}
