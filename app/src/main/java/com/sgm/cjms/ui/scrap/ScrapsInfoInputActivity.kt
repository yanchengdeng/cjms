package com.sgm.cjms.ui.scrap

import android.os.Bundle
import com.blankj.utilcode.util.ActivityUtils
import com.sgm.cjms.R
import com.sgm.cjms.base.BaseActivity
import com.sgm.cjms.databinding.ActivityScrapsInfoInputBinding
import com.sgm.cjms.ui.viewmodle.ScrapsInputViewModel
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.ext.view.clickNoRepeat

/**
 * @Author: yancheng
 * @Date: 2023/3/22 23:57
 * @Description:废料录入
 */
class ScrapsInfoInputActivity :  BaseActivity<ScrapsInputViewModel, ActivityScrapsInfoInputBinding>() {


    override fun initView(savedInstanceState: Bundle?) {
        mViewBind.commonTitle.ivBack.clickNoRepeat { finish() }
        mViewBind.commonTitle.tvTitle.text = getString(R.string.scraps_info_input)



        mViewBind.btnNext.clickNoRepeat {
            ActivityUtils.startActivity(ScrapsInfoDefectActivity::class.java)
        }

    }


}