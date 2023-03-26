package com.sgm.cjms.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.sgm.cjms.R

/**
 * @author  : yanc
 */
class MouldLabelAdapter(data : MutableList<String>) : BaseQuickAdapter<String, BaseViewHolder>(
    R.layout.adapter_label_item, data = data) {
    override fun convert(holder: BaseViewHolder, item: String) {

        holder.setText(R.id.tvLabel, "$item")


    }
}