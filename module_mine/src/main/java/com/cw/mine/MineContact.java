package com.cw.mine;

import com.cw.common.BaseFragment;
import com.cw.mine.api.IMine;
import com.cw.mine.ui.MineFragment;

/**
 * @author Cw
 * @date 2020/8/6
 */
public class MineContact implements IMine {

    private static MineContact instance;

    private MineContact() {
    }

    public static MineContact getInstance() {
        if (instance == null) {
            instance = new MineContact();
        }
        return instance;
    }

    @Override
    public BaseFragment getMineFragment() {
        return MineFragment.Companion.newInstance();
    }
}
