package com.sgm.cjms.data

import com.sgm.cjms.api.ApiService
import me.hgj.jetpackmvvm.network.BaseResponse

data class ApiResponse<T>(val status: Int, val message: String?, val data: T) : BaseResponse<T>() {

    // 错误码为 1 就代表请求成功，请你根据自己的业务需求来改变
    override fun isSucces() = status == ApiService.SERVER_RESULT_OK

    override fun getResponseCode() = status

    override fun getResponseData() = data

    override fun getResponseMsg() = message

}