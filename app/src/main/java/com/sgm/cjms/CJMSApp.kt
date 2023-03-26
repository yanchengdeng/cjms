package com.sgm.cjms

import android.app.Application
import com.blankj.utilcode.util.Utils
import com.sgm.cjms.util.L
import com.tencent.mmkv.MMKV

/**
 * @author  : yanc
 * @date : 2022/8/9
 * @time : 21:38
 * @desc :
 */
class CJMSApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Utils.init(this)

      var root =   MMKV.initialize(this)
        L.d("mmvm  root is $root")

    }
}