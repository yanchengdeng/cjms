package com.sgm.cjms.util

import android.text.TextUtils
import com.blankj.utilcode.util.ActivityUtils
import com.lxj.xpopup.XPopup


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
     * @param roughcastCode 铸造毛坯码
     * @param readyMachiningCode 预加工码
     */
    fun getUnionKey(roughcastCode : String?,readyMachiningCode : String?) : String?{
        if (TextUtils.isEmpty(roughcastCode) && TextUtils.isEmpty(readyMachiningCode)){
            L.e("必须🐴不存在，不存在此情况")
            return ""
        }else{
            if (!TextUtils.isEmpty(roughcastCode)){
                return roughcastCode
            }
            return readyMachiningCode
        }
    }



}