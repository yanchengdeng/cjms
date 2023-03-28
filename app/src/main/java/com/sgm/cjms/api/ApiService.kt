package com.sgm.cjms.api

import com.sgm.cjms.data.ApiResponse
import com.sgm.cjms.data.BaseListInfo
import com.sgm.cjms.data.ScrapsInfo
import com.sgm.cjms.data.UserInfo
import okhttp3.RequestBody
import retrofit2.http.*


interface ApiService {

    companion object {
        ///返回结果为1 表示正确返回
        const val SERVER_RESULT_OK = 1
        //0 错误提示
        const val SERVER_RESULT_ERROR = 0
        ///统一接口返回 585 则表示token过期需要重新登录获取
        // 文件服务则是 500 表示token 过期
        const val TOKEN_OUT_CODE = 585
        const val FILE_SERVER_TOKEN_OUT_CODE = 500
    }

//    /**
//     * native/api/v1/ptUser/getUserInfo
//     * 获取用户信息
//     */
//    @Headers("x-resource-code:ptUser_getUserInfo")
//    @POST("native/api/v1/ptUser/getUserInfo")
//    suspend fun login(): ApiResponse<UserInfo>

    /**
     * native/api/v1/ptUser/getUserInfo
     * 获取用户信息
     */
    @Headers("x-resource-code:ptUser_getUserInfo")
    @POST("native/api/v1/ptUser/getUserInfo")
    suspend fun getUserInfo(): ApiResponse<UserInfo>



    /**
     * native/api/v2/pda/base/list
     * 获取基础信息
     */
    @Headers("x-resource-code:pda_base_list")
    @POST("native/api/v2/pda/base/list")
    suspend fun getBaseInfo(): ApiResponse<BaseListInfo>

    /**
     * native/api/v2/pda/material/list
     * 废料信息查询（72小时）
     */
    @Headers("x-resource-code:pda_material_list")
    @POST("native/api/v2/pda/material/list")
    suspend fun getMaterialList(): ApiResponse<MutableList<ScrapsInfo>>


    /**
     * native/api/v2/pda/material/save
     * 保存废料
     */
    @Headers("x-resource-code:pda_material_save")
    @POST("native/api/v2/pda/material/save")
    suspend fun saveMaterial(@Body body: RequestBody): ApiResponse<Any>









}