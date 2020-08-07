package com.cw.chat.ui

import android.os.Bundle
import com.cw.chat.R
import com.cw.common.BaseFragment

/**
 *
 * @author Cw
 * @date 2020/8/7
 */
class ChatFragment : BaseFragment() {
    companion object {
        fun newInstance(): ChatFragment {
            val fragment = ChatFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_conversation
    }

    override fun initView(arguments: Bundle?) {
    }
}