package com.cw.mine.pay;

import android.content.Context;
import android.content.Intent;

import com.cw.mine.api.IPay;

/**
 * @author Cw
 * @date 2020/8/6
 */
public class PayContact implements IPay {

    private static PayContact instance;

    private PayContact() {
    }

    public static PayContact getInstance() {
        if (instance == null) {
            instance = new PayContact();
        }
        return instance;
    }

    @Override
    public void openPayPage(Context context) {
        Intent intent = new Intent(context, PayActivity.class);
        context.startActivity(intent);
    }
}
