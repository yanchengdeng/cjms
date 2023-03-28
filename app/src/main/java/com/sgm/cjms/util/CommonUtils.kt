package com.sgm.cjms.util

import android.app.Activity
import android.text.TextUtils
import com.blankj.utilcode.util.ActivityUtils
import com.lxj.xpopup.XPopup
import com.sgm.cjms.R
import com.sgm.cjms.data.MainModule
import com.sgm.cjms.data.ScrapsInfo
import com.sgm.cjms.ui.MainActivity


/**
 * @author  : yanc
 * @desc :公共类
 */

object CommonUtils {

    fun logout() {
        CacheUtil.cleanKv()
    }

    fun showDefaultDialog(msg: String, okCallBack: () -> Unit, cancelCallBack: () -> Unit) {
        XPopup.Builder(ActivityUtils.getTopActivity()).asConfirm(
            "温馨提示", msg, "取消", "确认", {
                okCallBack.invoke()
            }, {
                cancelCallBack.invoke()
            }, false
        ).show()
    }




    /**
     * 获取废料信息记录的 唯一关键id
     * 二选一，两者都存在时显示铸造毛坯码
     *  roughcastCode 铸造毛坯码
     *  readyMachiningCode 预加工码
     */
    fun getUnionKey(scrapsInfo: ScrapsInfo): String {
        if (TextUtils.isEmpty(scrapsInfo.roughcastCode) && TextUtils.isEmpty(scrapsInfo.readyMachiningCode)) {
            L.e("必须🐴不存在，不存在此情况")
            return ""
        } else {
            if (!TextUtils.isEmpty(scrapsInfo.roughcastCode)) {
                return scrapsInfo.roughcastCode
            }
            return scrapsInfo.readyMachiningCode
        }
    }

    /**
     * 移除首页 和 当前页 中间的所有页面
     */
    fun finishMainBetweenThis(activity: Activity) {
        val allActivities = ActivityUtils.getActivityList()
        allActivities.forEach {
            if (it.javaClass !in listOf(MainActivity::class.java, activity::class.java)) {
                it.finish()
            }
        }
    }




}