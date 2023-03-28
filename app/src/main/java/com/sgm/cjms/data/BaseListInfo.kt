package com.sgm.cjms.data
//基础信息
data class BaseListInfo(
    //SGM基地
    val baseList: MutableList<BaseInfo>,
    //班次
    val classesList: MutableList<BaseInfo>,
    //缺陷来源
    val defectSourceList: MutableList<BaseInfo>,
//    缺陷类型
    val defectTypeList: MutableList<BaseInfo>,
    //零件面定义图
    val diagramAllList: MutableList<DiagramItem>,
    //零件号（包含历史版本）
    val pratList: MutableList<PartList>,
    //SGM产线
    val productLinesList: MutableList<BaseInfo>,
    //供应商
    val suppList: MutableList<Any>,
    //SGM车间区域
    val workshopList: MutableList<BaseInfo>
)
/**
 *
 *
constantCode  常量代码  string
constantId 常量ID integer(int32)
constantType 常量分类 string
constantValue 常量值 string
displayOrder 排序 integer(int32)
isValid 是否有效：0-否，1-是 integer(int32)
memo 备注 string
 */
data class BaseInfo(
    val constantCode: String,
    val constantId: Int,
    val constantType: String,
    val constantValue: String,
    val displayOrder: Int,
    val isValid: Int,
    val memo: String
)

/**
 * 历史零件号
 *
partHisList 历史零件号 array string
partNo  当前零件号  string
 */

data class PartList(
    val partHisList : MutableList<String>,
    //零件号
    val partNo : String
)

//所有版本定义面
data class DiagramItem(
    val diagramList: MutableList<Diagram>,
    //铸件基础信息Id
    val partNo: String
)

//零件面定义图明细信息详情面数据
data class Diagram(
    val partDiaDetailsList: MutableList<PartDiaDetails>,
    val partsDiagram: PartsDiagram
)

/**
 *
createBy 创建人 integer(int64)
createDate 创建时间 string(date-time)
diagramName 零件面名称F1/F2/F3/F4/F5/F6 string
imgName 零件面定义图URI名称 string
imgUri 零件面F1/F2/F3/F4/F5/F6各自对应的文件服务ID string
ttPartsDiagramDetailId 零件面定义图明细信息Id integer(int64)
ttPartsDiagramId 零件面定义图主信息Id integer(int64)
updateBy 更新人 integer(int64)
 */
data class PartDiaDetails(
    val createBy: Int,
    val createDate: String,
    val diagramName: String,
    val imgName: String,
    val imgUri: String,
    val ttPartsDiagramDetailId: Int,
    val ttPartsDiagramId: Int,
    val updateBy: Int
)

/**
 * 定义图版本号
 *
createBy 创建人 integer(int64)
createDate 创建时间 string(date-time)
diagramVersion 零件面定义图版本号 string
partNo 铸件基础信息Id string
ttPartsDiagramId 零件面定义图主键Id integer(int64)
updateBy 更新人 integer(int64)
 */

data class PartsDiagram(
    val createBy: Int,
    val createDate: String,
    val diagramVersion: String,
    val partNo: String,
    val ttPartsDiagramId: Int,
    val updateBy: Int
)