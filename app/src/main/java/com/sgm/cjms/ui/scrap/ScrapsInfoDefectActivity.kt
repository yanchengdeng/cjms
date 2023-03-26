package com.sgm.cjms.ui.scrap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blankj.utilcode.util.ActivityUtils
import com.sgm.cjms.R
import com.sgm.cjms.base.BaseActivity
import com.sgm.cjms.databinding.ActivityScrapsInfoDefectBinding
import com.sgm.cjms.databinding.ActivityScrapsInfoInputBinding
import com.sgm.cjms.ui.viewmodle.ScrapsInputViewModel
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.ext.view.clickNoRepeat

/**
 * @Author: yancheng
 * @Date: 2023/3/23 00:01
 * @Description:废料缺陷录入
 */
class ScrapsInfoDefectActivity :  BaseActivity<ScrapsInputViewModel, ActivityScrapsInfoDefectBinding>() {


    override fun initView(savedInstanceState: Bundle?) {
        mViewBind.commonTitle.ivBack.clickNoRepeat { finish() }
        mViewBind.commonTitle.tvTitle.text = getString(R.string.scraps_info_input_defect)

        mViewBind.btnNext.clickNoRepeat {
            ActivityUtils.startActivity(ScrapsInfoOtherActivity::class.java)
        }
    }
}