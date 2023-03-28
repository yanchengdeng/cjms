package com.sgm.cjms.ui.viewmodle

import androidx.lifecycle.MutableLiveData
import com.sgm.cjms.api.apiService
import com.sgm.cjms.data.UserInfo
import com.sgm.cjms.util.CacheUtil
import com.sgm.cjms.util.T
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.ext.request

/**
 * @author  : yanc
 * @desc :
 */
class SplashViewModel : BaseViewModel() {

    var userProfile : MutableLiveData<UserInfo> = MutableLiveData()


    fun  getUserInfo(){
//        request({ apiService.login()},{
//            CacheUtil.saveUserInfo(it)
//            userProfile.value = it
//        },{
//            T.toast(it.errorMsg)
//        })
    }
}