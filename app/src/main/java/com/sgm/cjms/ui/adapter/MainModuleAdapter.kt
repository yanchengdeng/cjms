package com.sgm.cjms.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.sgm.cjms.R
import com.sgm.cjms.data.MainModule

/**
 * @author  : yanc
 */
class MainModuleAdapter(data : MutableList<MainModule>) : BaseQuickAdapter<MainModule, BaseViewHolder>(
    R.layout.adapter_main_module, data = data) {
    override fun convert(holder: BaseViewHolder, item: MainModule) {
        holder.setText(R.id.tvTitle, item.name)
        holder.setImageResource(R.id.ivIcon,item.icon)
        if (item.isUnreadNum){
            holder.setGone(R.id.ivUpdate,true)
            holder.setVisible(R.id.tvUnreadNum, item.unReadNum > 0)
            holder.setText(R.id.tvUnreadNum,item.unReadNum.toString())
        }else{
            holder.setGone(R.id.tvUnreadNum,true)
            holder.setVisible(R.id.ivUpdate,true)
            holder.setImageResource(R.id.ivUpdate,item.smallIcon)
        }
    }
}