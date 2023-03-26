package com.sgm.cjms.data

import com.sgm.cjms.R

/**
 * author: yancheng
 * created on: 2023/3/22 23:38
 * description: 废料信息
 */



//首页列表模板
data class MainModule(
    val icon :Int,
    val name : Int,
    //未读消息数
    var unReadNum : Int = 0,
    //是否是未读消息类型
    var isUnreadNum : Boolean = true,
    //如果不是未读消息类型  则是其他小图标 参考  应用更新
    var smallIcon : Int = R.mipmap.icon_update
)

////废料信息
data class ScrapsInfo(

    //二选一，两者都存在时显示铸造毛坯码
    val roughcastCode : String,//铸造毛坯码
    val readyMachiningCode : String//预加工码
)


