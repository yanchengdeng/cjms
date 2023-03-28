package com.sgm.cjms

import android.annotation.SuppressLint
import android.app.Application
import android.view.Gravity
import com.blankj.utilcode.util.ColorUtils
import com.blankj.utilcode.util.ToastUtils
import com.blankj.utilcode.util.Utils
import com.sgm.cjms.util.L
import com.tencent.mmkv.MMKV
import com.xuexiang.xupdate.XUpdate

/**
 * @author  : yanc
 * @date : 2022/8/9
 * @time : 21:38
 * @desc :
 */
class CJMSApp : Application() {

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate() {
        super.onCreate()

        Utils.init(this)

        ToastUtils.getDefaultMaker().
        setBgColor(ColorUtils.getColor(R.color.black))
            .setTextColor(ColorUtils.getColor(R.color.white))
            .setGravity(Gravity.TOP,0,50)

      var root =   MMKV.initialize(this)
        L.d("mmvm  root is $root")


        XUpdate.get().init(this)

    }
}