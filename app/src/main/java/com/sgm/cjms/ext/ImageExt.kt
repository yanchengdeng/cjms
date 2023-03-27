package com.sgm.cjms.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.sgm.cjms.R

/**
 * author: yancheng
 * created on: 2022/10/3 16:27
 * description:
 */

//常规图片
fun ImageView.loadUrl(url : String?,defaultIcon : Int = R.mipmap.ic_launcher_round){
    Glide.with(this).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).apply(RequestOptions().error(defaultIcon)).into(this)

}


//圆形图片
fun ImageView.loadUrlCircle(url : String?,defaultIcon : Int = R.mipmap.ic_launcher_round){
    Glide.with(this).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).apply(RequestOptions().transform(CircleCrop()).error(defaultIcon)).into(this)


}

// 圆角图片
fun ImageView.loadUrlCorner(url : String?,corner : Int,defaultIcon : Int = R.mipmap.ic_launcher_round){
    Glide.with(this).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).apply(RequestOptions().transform(RoundedCorners(corner)).error(defaultIcon)).into(this)
}