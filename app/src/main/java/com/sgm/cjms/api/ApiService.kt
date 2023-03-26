package com.sgm.cjms.api

import com.sgm.cjms.data.ApiResponse
import com.sgm.cjms.data.user.UserInfo
import retrofit2.http.*


interface ApiService {

    companion object {
        ///接口域名统一配置  token失效返回 585
        const val SERVER_API_URL = "http://47.102.199.31:59101/rfidapp/rest/"

        ///返回结果为1 表示正确返回
        const val SERVER_RESULT_OK = 1;
        ///统一接口返回 585 则表示token过期需要重新登录获取
        // 文件服务则是 500 表示token 过期
        const val TOKEN_OUT_CODE = 585;
        const val FILE_SERVER_TOKEN_OUT_CODE = 500;
    }

    /**
     * 获取用户信息
     */
    @Headers("x-resource-code:login_user")
    @POST("login/user")
    suspend fun login(): ApiResponse<UserInfo>







}