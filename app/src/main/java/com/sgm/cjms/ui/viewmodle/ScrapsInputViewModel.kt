package com.sgm.cjms.ui.viewmodle

import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.ActivityUtils
import com.sgm.cjms.api.ApiService
import com.sgm.cjms.api.apiService
import com.sgm.cjms.data.ScrapsInfo
import com.sgm.cjms.ui.MainActivity
import com.sgm.cjms.ui.ScrapsListActivity
import com.sgm.cjms.util.CommonUtils
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.ext.request
import me.hgj.jetpackmvvm.ext.util.toJson
import okhttp3.MediaType
import okhttp3.RequestBody

/**
 * @Author: yancheng
 * @Date: 2023/3/23 00:04
 * @Description:废料信息录入
 */
class ScrapsInputViewModel : BaseViewModel() {

    private val scrapsInfo = MutableLiveData<ScrapsInfo>()

    //保存废料信息
    fun saveMaterial() {
        val body = RequestBody.create(
            MediaType.parse("application/json;charset=UTF-8"),
            scrapsInfo.toJson()
        )
        request({ apiService.saveMaterial(body) }, {
            ActivityUtils.startActivity(ScrapsListActivity::class.java)


        }, {

        })


    }


}