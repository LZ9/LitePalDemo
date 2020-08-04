package com.lodz.android.litepaldemo

import com.lodz.android.pandora.base.application.BaseApplication
import org.litepal.LitePal

/**
 * Application基类
 * @author zhouL
 * @date 2020/8/4
 */
class App :BaseApplication(){

    override fun onStartCreate() {
        LitePal.initialize(this)
        configTitleBarLayout()
    }

    /** 配置标题栏 */
    private fun configTitleBarLayout() {
        getBaseLayoutConfig().getTitleBarLayoutConfig().isNeedBackBtn = true
        getBaseLayoutConfig().getTitleBarLayoutConfig().backgroundColor = R.color.colorAccent
        getBaseLayoutConfig().getTitleBarLayoutConfig().titleTextColor = R.color.white
    }

    override fun onExit() {
    }
}