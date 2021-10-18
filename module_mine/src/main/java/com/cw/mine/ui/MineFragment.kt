package com.cw.mine.ui

import android.os.Bundle
import com.cw.common.BaseFragment
import com.cw.mine.R

/**
 *
 * @author Cw
 * @date 2020/8/7
 */
class MineFragment : BaseFragment() {
    companion object {
        fun newInstance(): MineFragment {
            val fragment = MineFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_mine
    }

    override fun initView(arguments: Bundle?) {
    }
}