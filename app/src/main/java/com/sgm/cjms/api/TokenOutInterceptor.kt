import com.blankj.utilcode.util.ActivityUtils
import com.google.gson.Gson
import com.sgm.cjms.api.ApiService
import com.sgm.cjms.data.ApiResponse
import com.sgm.cjms.ui.SplashActivity
import com.sgm.cjms.util.T
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import java.io.IOException

/**
 * 描述　: token过期拦截器
 */
class TokenOutInterceptor : Interceptor {

    val gson: Gson by lazy { Gson() }

    @kotlin.jvm.Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        return if (response.body() != null && response.body()!!.contentType() != null) {
            val mediaType = response.body()!!.contentType()
            if (response.code() == 200) {
                val string = response.body()!!.string()
                val responseBody = ResponseBody.create(mediaType, string)
                val apiResponse = gson.fromJson(string, ApiResponse::class.java)
                //判断逻辑 模拟一下
                if (apiResponse.status in listOf(
                        ApiService.TOKEN_OUT_CODE,
                        ApiService.FILE_SERVER_TOKEN_OUT_CODE
                    )
                ) {
                    //如果是普通的activity话 可以直接跳转，如果是navigation中的fragment，可以发送通知跳转
                    ActivityUtils.startActivity(SplashActivity::class.java)
                    ActivityUtils.finishOtherActivities(SplashActivity::class.java)
                } else if (apiResponse.status == ApiService.SERVER_RESULT_ERROR) {
                    T.toast(apiResponse.message ?: "服务异常，请稍后再试")
                }
                response.newBuilder().body(responseBody).build()
            }else{
                T.toast(response.message())
                response
            }
        } else {
            response
        }
    }
}