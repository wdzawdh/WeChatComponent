package com.cw.main;

import com.cw.common.BaseFragment;
import com.cw.main.api.IMain;
import com.cw.main.ui.MainFragment;

/**
 * @author Cw
 * @date 2020/8/6
 */
public class MainContact implements IMain {

    private static MainContact instance;

    private MainContact() {
    }

    public static MainContact getInstance() {
        if (instance == null) {
            instance = new MainContact();
        }
        return instance;
    }

    @Override
    public BaseFragment getMainFragment() {
        return MainFragment.Companion.newInstance();
    }
}
