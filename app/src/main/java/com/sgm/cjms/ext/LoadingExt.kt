package com.sgm.cjms.ext

import android.app.Activity
import androidx.fragment.app.Fragment
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView

/**
 * @author  : yanc
 * @date : 2022/8/10
 * @time : 1:45
 * @desc :
 */
private var loading: LoadingPopupView? = null


fun Activity.showLoadingExt(msg: String = "加载中...") {

    if (loading == null) {
        loading = XPopup.Builder(this)
            .asLoading()
    }
    loading?.setTitle(msg)
    loading?.show()

}

fun Activity.dismissLoadingExt(){
    loading?.dismiss()
}


fun Fragment.showLoadingExt(msg : String = "加载中..."){
    activity?.apply {
        if (loading == null) {
            loading = XPopup.Builder(this)
                .asLoading()
        }
        loading?.setTitle(msg)
        loading?.show()
    }
}

fun Fragment.dismissLoadingExt(){
    loading?.dismiss()
}