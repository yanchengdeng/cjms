package com.sgm.cjms.util

import com.blankj.utilcode.util.LogUtils
import com.sgm.cjms.constants.Constants

/**
 * @author  : yanc
 * @date : 2022/8/9
 * @time : 22:48
 * @desc : 日志信息
 */
object L {
     const val TAG = "yancheng"


    fun d(msg : String){
        if (Constants.DEBUG) {
            LogUtils.d(TAG, msg)
        }
    }

    fun e(msg : String){
        if (Constants.DEBUG) {
            LogUtils.e(TAG, msg)
        }
    }
}