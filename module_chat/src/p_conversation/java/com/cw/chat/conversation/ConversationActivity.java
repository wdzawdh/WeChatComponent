package com.cw.chat.conversation;

import android.os.Bundle;

import com.cw.chat.R;
import com.cw.common.BaseActivity;

import androidx.annotation.Nullable;

/**
 * @author Cw
 * @date 2020/8/6
 */
public class ConversationActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
    }
}
