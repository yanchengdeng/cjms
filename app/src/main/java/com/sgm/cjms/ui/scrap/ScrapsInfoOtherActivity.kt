package com.sgm.cjms.ui.scrap

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.luck.picture.lib.basic.PictureSelector
import com.luck.picture.lib.config.SelectMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.interfaces.OnResultCallbackListener
import com.sgm.cjms.R
import com.sgm.cjms.base.BaseActivity
import com.sgm.cjms.databinding.ActivityScrapsInfoOtherBinding
import com.sgm.cjms.ui.adapter.GridImageAdapter
import com.sgm.cjms.ui.adapter.GridImageAdapter.OnItemClickListener
import com.sgm.cjms.ui.viewmodle.ScrapsInputViewModel
import com.sgm.cjms.util.GlideEngine
import com.sgm.cjms.util.GridSpaceItemDecoration
import me.hgj.jetpackmvvm.ext.view.clickNoRepeat
import java.util.ArrayList

/**
 * @Author: yancheng
 * @Date: 2023/3/23 00:02
 * @Description:其他信息录入
 */
class ScrapsInfoOtherActivity :
    BaseActivity<ScrapsInputViewModel, ActivityScrapsInfoOtherBinding>() {

    private var photoData = mutableListOf<LocalMedia>()
    private lateinit var photoAdapter: GridImageAdapter;

    override fun initView(savedInstanceState: Bundle?) {
        mViewBind.commonTitle.ivBack.clickNoRepeat { finish() }
        mViewBind.commonTitle.tvTitle.text = getString(R.string.scraps_info_input_other)
        initPhoto()
    }

    private fun initPhoto() {
        val manage = GridLayoutManager(
            this,
            4, GridLayoutManager.VERTICAL, false
        );
        val animal = mViewBind.rvPhoto.animation
        animal?.apply {
            (this as SimpleItemAnimator).supportsChangeAnimations = false
        }
        mViewBind.rvPhoto.addItemDecoration(GridSpaceItemDecoration(4))

        photoAdapter = GridImageAdapter(this, photoData)
        photoAdapter.selectMax = 3
        mViewBind.rvPhoto.layoutManager = manage
        mViewBind.rvPhoto.adapter = photoAdapter

        photoAdapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(v: View?, position: Int) {
                PictureSelector.create(this@ScrapsInfoOtherActivity)
                    .openPreview()
                    .setImageEngine(GlideEngine.createGlideEngine())
                    .startActivityPreview(position,false,photoAdapter.data)

            }

            override fun openPicture() {
                PictureSelector.create(this@ScrapsInfoOtherActivity)
                    .openGallery(SelectMimeType.TYPE_IMAGE)
                    .isPreviewImage(false)
                    .setImageEngine(GlideEngine.createGlideEngine())
                    .setMaxSelectNum(3)
                    .setSelectedData(photoAdapter.data)
                    .forResult(object : OnResultCallbackListener<LocalMedia> {
                        override fun onResult(result: ArrayList<LocalMedia>?) {
                            result?.let {
                                photoAdapter.data.clear()
                                photoAdapter.data.addAll(result)
                                photoAdapter.notifyDataSetChanged()
                            }

                        }

                        override fun onCancel() {
                        }
                    })
            }

        })
    }
}