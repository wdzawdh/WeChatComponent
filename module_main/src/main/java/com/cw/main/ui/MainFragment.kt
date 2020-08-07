package com.cw.main.ui

import android.os.Bundle
import android.widget.Toast
import com.cw.chat.api.ChatApi
import com.cw.chat.api.IConversation
import com.cw.common.BaseFragment
import com.cw.main.R
import com.cw.mine.api.IMine
import com.cw.mine.api.ISetting
import com.cw.mine.api.MineApi
import kotlinx.android.synthetic.main.fragment_home.*

/**
 *
 * @author Cw
 * @date 2020/8/7
 */
class MainFragment : BaseFragment() {
    companion object {
        fun newInstance(): MainFragment {
            val fragment = MainFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initView(arguments: Bundle?) {
        btnOpenChat.setOnClickListener {
            val conversationApi = ChatApi.get(IConversation::class.java)
            if (conversationApi != null) {
                conversationApi.openConversationPage(context)
            } else {
                Toast.makeText(context, "Chat模块未安装", Toast.LENGTH_SHORT).show()
            }
        }
        btnOpenSetting.setOnClickListener {
            val settingApi = MineApi.get(ISetting::class.java)
            if (settingApi != null) {
                settingApi.openSettingPage(context)
            } else {
                Toast.makeText(context, "Mine模块未安装", Toast.LENGTH_SHORT).show()
            }
        }
    }
}