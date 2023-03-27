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

//料废数据选择后需要记录信息
//SGM基地代号 baseCode 可选，选中一次后，下次默认
//SGM车间区域 workshop  根据基地，提供可选车间区域，选中一次后，下次默认
//SGM产线  prodLine 根据基地、车间区域，提供可选生产线，选中一次后，下次默认
//毛坯零件号 partNo 根据基地、车间区域，生产线，可选毛坯零件号，选中一次后，下次默认

enum class ScrapsMarkType {
    BASE_CODE,
    WORK_SHOP,
    PROD_LINE,
    PART_NO
}


//料废列表 分类  当日、全部、已上传、待上传
enum class ScrapsListType{
    TOADY,
    ALL,
    UPLOADED,
    WAITING,
}



////废料信息
data class ScrapsInfo(

    var baseCode : String,
    var workshop : String,
    var prodLine : String,
    var partNo : String,
    //二选一，两者都存在时显示铸造毛坯码
    val roughcastCode : String,//铸造毛坯码
    val readyMachiningCode : String//预加工码
)


