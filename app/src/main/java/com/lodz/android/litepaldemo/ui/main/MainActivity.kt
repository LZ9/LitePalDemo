package com.lodz.android.litepaldemo.ui.main

import android.os.Bundle
import android.widget.Button
import com.lodz.android.corekt.anko.bindView
import com.lodz.android.litepaldemo.R
import com.lodz.android.litepaldemo.ui.normal.NormalActivity
import com.lodz.android.pandora.base.activity.BaseActivity
import com.lodz.android.pandora.widget.base.TitleBarLayout

/**
 * 主页
 * @author zhouL
 * @date 2020/8/4
 */
class MainActivity : BaseActivity() {

    private val mNormalBtn by bindView<Button>(R.id.normal_btn)
    private val mRxBtn by bindView<Button>(R.id.rx_btn)
    private val mJetpackBtn by bindView<Button>(R.id.jetpack_btn)

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun findViews(savedInstanceState: Bundle?) {
        super.findViews(savedInstanceState)
        initTitleBar(getTitleBarLayout())
    }

    private fun initTitleBar(titleBarLayout: TitleBarLayout) {
        titleBarLayout.setTitleName(R.string.app_name)
        titleBarLayout.needBackButton(false)
    }

    override fun setListeners() {
        super.setListeners()
        mNormalBtn.setOnClickListener {
            NormalActivity.start(getContext())
        }

        mRxBtn.setOnClickListener {
//            RxActivity.start(getContext())
        }

        mJetpackBtn.setOnClickListener {
//            VmActivity.start(getContext())
        }
    }

    override fun initData() {
        super.initData()
        showStatusCompleted()
    }

}