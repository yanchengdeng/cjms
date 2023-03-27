package com.sgm.cjms.ui

import android.os.Bundle
import com.sgm.cjms.R
import com.sgm.cjms.base.BaseActivity
import com.sgm.cjms.databinding.ActivityDataCacheBinding
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.ext.view.clickNoRepeat

class DataCacheActivity : BaseActivity<BaseViewModel,ActivityDataCacheBinding>() {


    override fun initView(savedInstanceState: Bundle?) {

        mViewBind.commonTitle.ivBack.clickNoRepeat { finish() }
        mViewBind.commonTitle.tvTitle.text = getString(R.string.data_cache)
    }
}