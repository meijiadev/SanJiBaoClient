package com.example.sanjibaoclient.app

import android.content.Intent
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.example.architecture.action.ToastAction
import com.example.architecture.ui.activity.BaseVmDbActivity
import com.example.architecture.viewmodel.BaseViewModel
import com.example.sanjibaoclient.R
import com.gyf.immersionbar.BarHide
import com.gyf.immersionbar.ImmersionBar


/**
 *    author : MJ
 *    time   : 2022/04/11
 *    desc   : 业务层的BaseActivity,集成viewModel 和DataBinding
 */
abstract class AppVmDbActivity<VM:BaseViewModel,DB:ViewDataBinding> : BaseVmDbActivity<VM, DB>(),ToastAction {

    protected override fun init() {
        super.init()
        // 初始化沉浸式状态栏
        if (isStatusBarEnabled()) {
            createStatusBarConfig().init()
        }
    }

    /**
     * 是否使用沉浸式状态栏
     */
    protected open fun isStatusBarEnabled(): Boolean {
        return true
    }
    /**
     * 初始化沉浸式状态栏
     */
    protected open fun createStatusBarConfig(): ImmersionBar {
        return ImmersionBar.with(this).hideBar(BarHide.FLAG_HIDE_STATUS_BAR)
    }

    override fun startActivityForResult(intent: Intent, requestCode: Int, options: Bundle?) {
        super.startActivityForResult(intent, requestCode, options)
        overridePendingTransition(R.anim.right_in_activity, R.anim.right_out_activity)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.left_in_activity, R.anim.left_out_activity)
    }

    override fun onDestroy() {
        super.onDestroy()

    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        ImmersionBar.hideStatusBar(window)
    }
}