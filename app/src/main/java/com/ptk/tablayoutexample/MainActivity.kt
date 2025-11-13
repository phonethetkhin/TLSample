package com.ptk.tablayoutexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var tlMain: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tlMain = findViewById<TabLayout>(R.id.tlMain)

        supportFragmentManager.beginTransaction().replace(R.id.fcMain, OrdersFragment()).commit()

        tlMain.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                var fragment: Fragment = OrdersFragment()
                when (tab?.position) {
                    0 -> fragment = OrdersFragment()
                    1 -> fragment = FoodsFragment()
                    2 -> fragment = DrinkFragment()
                }
                supportFragmentManager.beginTransaction().replace(R.id.fcMain, fragment).commit()

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })


    }

    override fun onBackPressed() {
        if (tlMain.selectedTabPosition != 0) {
            tlMain.selectTab(tlMain.getTabAt(0))
        } else {
            super.onBackPressed()
        }
    }
}