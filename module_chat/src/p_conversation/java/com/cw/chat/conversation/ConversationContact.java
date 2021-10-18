package com.cw.chat.conversation;

import android.content.Context;
import android.content.Intent;

import com.cw.chat.api.IConversation;
import com.cw.chat.api.model.Conversation;

import java.util.ArrayList;
import java.util.List;

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
    public List<Conversation> getConversationList() {
        return new ArrayList<>();
    }

    @Override
    public void openConversationPage(Context context) {
        Intent intent = new Intent(context, ConversationActivity.class);
        context.startActivity(intent);
    }
}
