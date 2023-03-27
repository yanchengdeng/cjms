package com.sgm.cjms.ui.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.blankj.utilcode.util.ActivityUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.core.ImageViewerPopupView
import com.lxj.xpopup.interfaces.OnSrcViewUpdateListener
import com.lxj.xpopup.interfaces.XPopupImageLoader
import com.lxj.xpopup.photoview.PhotoView
import com.lxj.xpopup.util.SmartGlideImageLoader
import com.sgm.cjms.R
import com.sgm.cjms.data.MainModule
import com.sgm.cjms.data.ScrapsInfo
import com.sgm.cjms.ext.loadUrl
import com.sgm.cjms.util.CommonUtils
import com.sgm.cjms.util.L
import me.hgj.jetpackmvvm.ext.util.toJson
import me.hgj.jetpackmvvm.ext.view.clickNoRepeat
import java.io.File

/**
 * 缺陷图片
 * @author  : yanc
 */
class DefectImageAdapter(data : MutableList<String>) : BaseQuickAdapter<String, BaseViewHolder>(
    R.layout.adapter_defect_image, data = data) {
    override fun convert(holder: BaseViewHolder, item: String) {

        holder.getView<ImageView>(R.id.ivImage).loadUrl(item)


        holder.getView<ImageView>(R.id.ivImage).clickNoRepeat {
            XPopup.Builder(ActivityUtils.getTopActivity()).asImageViewer(it as ImageView,
                holder.adapterPosition,
                data as List<Any>?,
                { _, position -> L.d(""+position) }, SmartGlideImageLoader()
            ).isShowSaveButton(false).show()
        }

    }
}