package com.sgm.cjms.util

import com.sgm.cjms.R
import com.sgm.cjms.data.MainModule

/**
 * author: yancheng
 * created on: 2023/3/27 23:40
 * description: 基础数据来源
 */
object DataResourceUtil {


    /**
     * 初始化首页数据模板
     */
    fun initMainModules(): MutableList<MainModule> {
        return mutableListOf(
            MainModule(icon = R.mipmap.ic_launcher_round, name = R.string.mark_scraps, isUnreadNum = true, unReadNum = 20),
            MainModule(icon = R.mipmap.ic_launcher_round, name = R.string.scraps_record, isUnreadNum = true, unReadNum = 30),
            MainModule(icon = R.mipmap.ic_launcher_round, name = R.string.curb, isUnreadNum = true, unReadNum = 10),
            MainModule(icon = R.mipmap.ic_launcher_round, name = R.string.refresh_cache_data, isUnreadNum = true, unReadNum = 0),
            MainModule(
                icon = R.mipmap.ic_launcher_round,
                name = R.string.check_app,
                isUnreadNum = false, unReadNum = 0
            ),
        )
    }

    //来源
    // 数据验证范围【机加工、装配、PDA、GA、售后、其他】
    //M=机加工
    //A=装配
    //P=PDA
    //G=GA
    //S=售后
    //O=其他
    fun  getSourceInfo(): HashMap<String,String> {
        return hashMapOf(
            "M" to "机加工",
            "A" to "装配",
            "P" to "PDA",
            "G" to "GA",
            "S" to "售后",
            "O" to "其他",
        )
    }

    //班次名称
    //A=早班
    //B=中班
    //C=晚班
    fun getFrequency() : HashMap<String,String>{
        return hashMapOf(
            "A" to "早班",
            "B" to "午班",
            "C" to "晚班",

        )
    }
}