package com.cw.chat;

import com.cw.chat.api.IChat;
import com.cw.chat.ui.ChatFragment;
import com.cw.common.BaseFragment;

/**
 * @author Cw
 * @date 2020/8/6
 */
public class ChatContact implements IChat {

    private static ChatContact instance;

    private ChatContact() {
    }

    public static ChatContact getInstance() {
        if (instance == null) {
            instance = new ChatContact();
        }
        return instance;
    }

    @Override
    public BaseFragment getChatFragment() {
        return ChatFragment.Companion.newInstance();
    }
}
