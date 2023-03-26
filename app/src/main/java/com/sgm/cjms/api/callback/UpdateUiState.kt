package com.sgm.cjms.api.callback

data class UpdateUiState<T>(
    //请求是否成功
    var state: Int = 0,
    //操作的对象
    var data: T? = null,
    //请求失败的错误信息
    var message: String = ""
)