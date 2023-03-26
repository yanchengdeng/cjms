package com.sgm.cjms.ui.fragment

import android.os.Bundle
import com.blankj.utilcode.util.ActivityUtils
import com.sgm.cjms.R
import com.sgm.cjms.base.BaseFragment
import com.sgm.cjms.databinding.FragmentMineBinding
import com.sgm.cjms.ui.SplashActivity
import com.sgm.cjms.util.CacheUtil
import com.sgm.cjms.util.CommonUtils
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel

/**
 * @author  : yanc
 * @date : 2022/8/10
 * @time : 2:21
 * @desc :
 */
class MineFragment : BaseFragment<BaseViewModel, FragmentMineBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

        var userInfo = CacheUtil.getUserInfo()
        userInfo?.apply {
           mViewBind.tvUseName.text = this.name
            mViewBind.tvUseCode.text = this.userCode
        }

        mViewBind.btnLogout.setOnClickListener {
            CommonUtils.showDefaultDialog(getString(R.string.sure_logout), okCallBack = {
                CommonUtils.logout()
                ActivityUtils.startActivity(SplashActivity::class.java)
                activity?.finish()
            }, cancelCallBack = {

            })

        }
    }
}