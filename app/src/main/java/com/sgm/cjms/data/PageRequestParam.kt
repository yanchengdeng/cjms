package com.sgm.cjms.data

import com.sgm.cjms.constants.Constants

/**
 * @author  : yanc
 * @desc : 网络请求参数
 */
class PageRequestParam (val pageNum :Int,val pageSize : Int = Constants.PAGE_SIZE)