package com.sgm.cjms.util

import com.blankj.utilcode.util.GsonUtils
import com.sgm.cjms.data.user.UserInfo
import com.tencent.mmkv.MMKV

/**
 * @author  : yanc
 * @desc : 其他缓存内容  用户code  token
 */
object CacheUtil {

    private const val USER_CODE = "user_code"
    private const val X_MID_TOKEN = "x-mid_token"
    private const val USER_INFO = "user_info"
    //保存下发的模具

    var kv = MMKV.defaultMMKV()

    //保存用户账号
     fun saveUserCode(userCode : String){
        kv.encode(USER_CODE,userCode)
    }

    //获取用户账号
     fun getUserCode() : String {
        return kv.decodeString(USER_CODE,"spl01") ?: "spl01"
    }


    //保存x-mid-token
    fun saveXmidToken(midToken : String){
        kv.encode(X_MID_TOKEN,midToken)
    }

    //获取x-mid-token
    fun getXmidToken():String{
        return  kv.decodeString(X_MID_TOKEN) ?: ""
    }

    //保存用户数据
    fun  saveUserInfo(userInfo: UserInfo){
        kv.encode(USER_INFO,GsonUtils.toJson(userInfo))
    }

    fun  getUserInfo() : UserInfo?{
        var userInfo = kv.decodeString(USER_INFO,"") ?:""
        if (userInfo.isEmpty()){
            return null
        }
        return GsonUtils.fromJson(userInfo,UserInfo::class.java)
    }


    //清除缓存信息
    fun cleanKv(){
        kv.encode(USER_INFO,"")
//        kv.encode(USER_CODE,"")
        kv.encode(X_MID_TOKEN,"")
    }

}