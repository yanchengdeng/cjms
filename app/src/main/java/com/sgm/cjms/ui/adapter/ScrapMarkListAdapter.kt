package com.sgm.cjms.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.sgm.cjms.R
import com.sgm.cjms.data.MainModule
import com.sgm.cjms.data.ScrapsInfo
import com.sgm.cjms.util.CommonUtils

/**
 * 料废记录
 * @author  : yanc
 */
class ScrapMarkListAdapter(data : MutableList<ScrapsInfo>) : BaseQuickAdapter<ScrapsInfo, BaseViewHolder>(
    R.layout.adapter_scraps_list, data = data) {
    override fun convert(holder: BaseViewHolder, item: ScrapsInfo) {
        holder.setText(R.id.tvRecordId, CommonUtils.getUnionKey(item))

    }
}