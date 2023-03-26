package com.sgm.cjms.ui

import android.os.Bundle
import android.view.View
import com.blankj.utilcode.util.ActivityUtils
import com.sgm.cjms.R
import com.sgm.cjms.base.BaseActivity
import com.sgm.cjms.databinding.ActivityMainBinding
import com.sgm.cjms.ui.scrap.ScrapsInfoInputActivity
import com.sgm.cjms.util.T
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.ext.view.clickNoRepeat

/**
*@Describe ：首页
*@author : yanc
*@Time : 9:56
**/
class MainActivity : BaseActivity<BaseViewModel,ActivityMainBinding>() {


    override fun initView(savedInstanceState: Bundle?) {
        mViewBind.commonTitle.ivBack.visibility = View.INVISIBLE
        mViewBind.commonTitle.tvTitle.text = getString(R.string.main_home)


        mViewBind.btnMarkScraps.clickNoRepeat {
            ActivityUtils.startActivity(ScrapsInfoInputActivity::class.java)
        }

        mViewBind.btnRefreshCacheData.clickNoRepeat {
            ActivityUtils.startActivity(DataCacheActivity::class.java)
        }
    }

    override fun isSupportBarcodeReader() : Boolean{
        return true
    }



    var currentTimeMillis = 0L
    override fun onBackPressed() {
        if (System.currentTimeMillis() - currentTimeMillis > 2000L) {
            currentTimeMillis = System.currentTimeMillis()
            T.toast(getString(R.string.exit_when_back_press))
        } else {
            super.onBackPressed()
        }
    }
}