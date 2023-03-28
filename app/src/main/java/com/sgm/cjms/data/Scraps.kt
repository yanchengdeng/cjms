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


/**
 *
baseCode 基地代号 string
createBy 创建人 integer(int64)
createDate 创建时间 string(date-time)
defectDropLocation 缺陷位置（点，如3F，标准化） string
defectFaceLocation 缺陷位置（面，如F1，标准化） string
defectRemark 缺陷描述 string
defectType 缺陷名称（标准化） string
duns DUNS号 string
frequency 班次 string
partName 零件名称 string
partNo 零件号 string
platCode 平台 string
prodLine 产线 string
readyMachiningCode 预加工码 string
remark 备注 string
roughcastCode 铸造毛坯码 string
sourceInfo 来源 string
supplierName 供应商名称 string
ttPtSpMaterialId 主键Id integer(int32)
updateBy 更新人 integer(int64)
wasteStatisticsDate 统计料废时间 string(date-time)
wasteStatisticsName 统计料废人员
whetherStatistics 是否计入料废（是，否，默认是）
workshop 车间
 */
data class ScrapsInfo(

    var baseCode: String,
    var createBy: Int,
    var createDate: String,
    var defectDropLocation: String,
    var defectFaceLocation: String,
    var defectRemark: String,
    var defectType: String,
    var duns: String,
    var frequency: String,
    var partName: String,
    var partNo: String,
    var platCode: String,
    var prodLine: String,
    var readyMachiningCode: String,
    var remark: String,
    var roughcastCode: String,
    var sourceInfo: String,
    var supplierName: String,
    var ttPtSpMaterialId: Int,
    var updateBy: Int,
    var wasteStatisticsDate: String,
    var wasteStatisticsName: String,
    var whetherStatistics: String,
    var workshop: String,
    var imageOne : Image,
    var imageTwo  : Image,
    var imageThree : Image
)

//图片构造类 如果已经上传则取网络图片
data class Image(
    //本地图片
    var nativeUrl : String,
    //网络图片
    var netUrl : String

)

//废料保存模板
data class SaveScraps(
    val baseCode: String,
    val defectDropLocation: String,
    val defectFaceLocation: String,
    val defectRemark: String,
    val defectType: String,
    val duns: String,
    val frequency: String,
    val imageOne: String,
    val imageThree: String,
    val imageTwo: String,
    val partNo: String,
    val platCode: String,
    val prodLine: String,
    val readyMachiningCode: String,
    val remark: String,
    val roughcastCode: String,
    val sourceInfo: String,
    val supplierName: String,
    val wasteStatisticsDate: String,
    val wasteStatisticsName: String,
    val whetherStatistics: String,
    val workshop: String
)


