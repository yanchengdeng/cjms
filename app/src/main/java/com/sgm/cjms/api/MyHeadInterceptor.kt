package com.sgm.cjms.api

import com.sgm.cjms.util.CacheUtil
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * 自定义头部参数拦截器，传入heads
 *
 * if (Get.isRegistered<UserStore>() && UserStore.to.hasToken == true) {
headers['x-mid-token'] = '${UserStore.to.token}';
}
headers['x-track-code'] = DateTime.now().microsecondsSinceEpoch;
headers['x-app-code'] = 'RFIDAPP';
headers['content-type'] = 'application/json; charset=utf-8';
headers['contentType'] = 'application/json; charset=utf-8';

if (UserStore.to.userLoginResponseEntity != null) {
headers['x-user-code'] =
UserStore.to.userLoginResponseEntity?.data.userCode;
} else {
headers['x-user-code'] = 'spl01';
}
 */
class MyHeadInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("x-track-code", System.currentTimeMillis().toString()).build()
        builder.addHeader("x-app-code", "CJMS_APP").build()
        builder.addHeader("x-user-code", CacheUtil.getUserCode()).build()
        builder.addHeader("Content-type", "application/json;charset=UTF-8")
        // TODO: 待后期确认后更改
        builder.addHeader("x-user-name", "Pass1234")
//        builder.addHeader("x-mid-token", CacheUtil.getXmidToken()).build()
        return chain.proceed(builder.build())
    }

}