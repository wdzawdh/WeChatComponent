package com.cw.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.cw.chat.api.ChatApi
import com.cw.chat.api.IChat
import com.cw.main.R
import com.cw.main.api.IMain
import com.cw.main.api.MainApi
import com.cw.mine.api.IMine
import com.cw.mine.api.MineApi
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mFragments: ArrayList<Fragment>
    private lateinit var mTabs: ArrayList<String>

    private var mCurrentItem: Int = 0

    private val iconSelectIds = intArrayOf(
            R.drawable.main_nav_shouye_current,
            R.drawable.main_nav_news_current,
            R.drawable.main_nav_my_current
    )

    private val iconUnSelectIds = intArrayOf(
            R.drawable.main_nav_shouye_normal,
            R.drawable.main_nav_news_normal,
            R.drawable.main_nav_my_normal
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        mFragments = arrayListOf()
        mTabs = arrayListOf()

        val mainApi = MainApi.get(IMain::class.java)
        if (mainApi?.mainFragment != null) {
            mFragments.add(mainApi.mainFragment)
            mTabs.add("主页Main")
        }

        val chatApi = ChatApi.get(IChat::class.java)
        if (chatApi?.chatFragment != null) {
            mFragments.add(chatApi.chatFragment)
            mTabs.add("聊天Chat")
        }

        val mineApi = MineApi.get(IMine::class.java)
        if (mineApi?.mineFragment != null) {
            mFragments.add(mineApi.mineFragment)
            mTabs.add("我的Mine")
        }

        initViewPager()
        initTabLayout()
    }

    private fun initViewPager() {
        viewPager.clearOnPageChangeListeners()
        viewPager.offscreenPageLimit = mFragments.size
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                mCurrentItem = position
            }
        })
        viewPager.adapter = object : FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            override fun getItem(position: Int): Fragment {
                return mFragments[position]
            }

            override fun getCount(): Int {
                return mFragments.size
            }
        }
    }

    private fun initTabLayout() {
        tabLayout.setupWithViewPager(viewPager)
        for (i in 0 until mTabs.size) {
            val tab = tabLayout.getTabAt(i)
            val view = LayoutInflater.from(this)
                    .inflate(R.layout.view_nav_item, tabLayout, false)

            val ivItem = view.findViewById<ImageView>(R.id.ivItem)
            val tvTab = view.findViewById<TextView>(R.id.tvTab)
            if (i == mCurrentItem) {
                ivItem.setImageResource(iconSelectIds[i])
                tvTab.setTextColor(ContextCompat.getColor(baseContext, R.color.c_212121))
            } else {
                ivItem.setImageResource(iconUnSelectIds[i])
                tvTab.setTextColor(ContextCompat.getColor(baseContext, R.color.c_CCCCCC))
            }
            tvTab.text = mTabs[i]
            tab?.customView = view
            val viewGroup = tab?.customView?.parent as ViewGroup
            viewGroup.clipChildren = false
            viewGroup.clipToPadding = false
        }
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val tvTab = tab.customView?.findViewById<TextView>(R.id.tvTab)
                val ivItem = tab.customView?.findViewById<ImageView>(R.id.ivItem)
                tvTab?.setTextColor(ContextCompat.getColor(baseContext, R.color.c_CCCCCC))
                ivItem?.setImageResource(iconUnSelectIds[tab.position])
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                val tvTab = tab.customView?.findViewById<TextView>(R.id.tvTab)
                val ivItem = tab.customView?.findViewById<ImageView>(R.id.ivItem)
                tvTab?.setTextColor(ContextCompat.getColor(baseContext, R.color.c_212121))
                ivItem?.setImageResource(iconSelectIds[tab.position])
            }
        })
    }
}