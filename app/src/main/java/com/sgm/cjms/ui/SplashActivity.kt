package com.sgm.cjms.ui

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Bundle
import android.webkit.*
import com.blankj.utilcode.util.ActivityUtils
import com.sgm.cjms.R
import com.sgm.cjms.base.BaseActivity
import com.sgm.cjms.constants.Constants
import com.sgm.cjms.databinding.ActivitySplashBinding
import com.sgm.cjms.ui.viewmodle.SplashViewModel
import com.sgm.cjms.util.CacheUtil
import com.sgm.cjms.util.L
import com.sgm.cjms.util.T

class SplashActivity : BaseActivity<SplashViewModel, ActivitySplashBinding>() {



    var currentTimeMillis = 0L
    override fun onBackPressed() {
        if (System.currentTimeMillis() - currentTimeMillis > 2000L) {
            currentTimeMillis = System.currentTimeMillis()
            T.toast(getString(R.string.exit_when_back_press))
        } else {
            super.onBackPressed()
        }
    }


    //清除webview 缓存
    override fun onStop() {
        super.onStop()

        var hasCookies = CookieManager.getInstance()
        hasCookies.removeAllCookies {
            L.d("删除removeAllCookies=${it}")
        }

        hasCookies.removeSessionCookies {
            L.d("删除removeSessionCookies=${it}")
        }

        mViewBind.webView.clearCache(true)
        mViewBind.webView.clearHistory()
        WebStorage.getInstance().deleteAllData()

    }

    override fun createObserver() {
        super.createObserver()
        mViewModel.userProfile.observe(this) {
            dismissLoading()
            ActivityUtils.startActivity(MainActivity::class.java)
            finish()
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun initView(savedInstanceState: Bundle?) {
//        if (CacheUtil.getXmidToken().isNotEmpty()) {
            ActivityUtils.startActivity(MainActivity::class.java)
            finish()
            return
//        }
        showLoading("加载中...")

        mViewBind.webView.settings.javaScriptEnabled = true
        mViewBind.webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        mViewBind.webView.loadUrl(Constants.WEB_LOGIN_URL)



        mViewBind.webView.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                L.d("onPageStarted : $url")
                super.onPageStarted(view, url, favicon)

                if (url?.contains(Constants.LOAD_LOGIN_VALID) == true) {
                    showLoading("验证中...")
                }

                if (url?.contains(Constants.WEB_LOAD_URL_KEY) == true) {
                    var listSplits = url.split(Constants.WEB_LOAD_URL_KEY);
                    if (listSplits.size == 2) {
                        var token = listSplits[1]
                        CacheUtil.saveXmidToken(token)
                        //待处理  请求 用户接口 获取用户userCode
                        mViewModel.getUserInfo()
                    }
                }
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                L.d("onPageFinished : $url")
                if (url?.contains(Constants.LOAD_LOGIN_UI) == true){
                    dismissLoading()
                }
                super.onPageFinished(view, url)

            }

            override fun onReceivedHttpError(
                view: WebView?,
                request: WebResourceRequest?,
                errorResponse: WebResourceResponse?
            ) {
                L.d("onReceivedHttpError : $errorResponse")
                super.onReceivedHttpError(view, request, errorResponse)
            }

            override fun onReceivedSslError(
                view: WebView?,
                handler: SslErrorHandler?,
                error: SslError?
            ) {
                handler?.proceed()
//                super.onReceivedSslError(view, handler, error)
            }

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                L.d("onReceivedError : $error")
                super.onReceivedError(view, request, error)
            }

            override fun onReceivedHttpAuthRequest(
                view: WebView?,
                handler: HttpAuthHandler?,
                host: String?,
                realm: String?
            ) {
                L.d("onPageFinished : $host----$realm")
                super.onReceivedHttpAuthRequest(view, handler, host, realm)
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }
        }
    }

}