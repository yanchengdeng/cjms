package com.sgm.cjms.data

/**
 * author: yancheng
 * created on: 2023/3/22 23:38
 * description: 废料信息
 */

////废料信息
data class ScrapsInfo(

    //二选一，两者都存在时显示铸造毛坯码
    val roughcastCode : String,//铸造毛坯码
    val readyMachiningCode : String//预加工码
)
