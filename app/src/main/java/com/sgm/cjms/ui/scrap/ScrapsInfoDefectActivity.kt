package com.sgm.cjms.ui.scrap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.inputmethod.EditorInfo
import androidx.recyclerview.widget.GridLayoutManager
import com.blankj.utilcode.util.ActivityUtils
import com.sgm.cjms.R
import com.sgm.cjms.base.BaseActivity
import com.sgm.cjms.databinding.ActivityScrapsInfoDefectBinding
import com.sgm.cjms.databinding.ActivityScrapsInfoInputBinding
import com.sgm.cjms.ext.setSelectionEnd
import com.sgm.cjms.ui.adapter.DefectImageAdapter
import com.sgm.cjms.ui.viewmodle.ScrapsInputViewModel
import com.sgm.cjms.util.GridSpaceItemDecoration
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.ext.view.clickNoRepeat

/**
 * @Author: yancheng
 * @Date: 2023/3/23 00:01
 * @Description:废料缺陷录入
 */
class ScrapsInfoDefectActivity :  BaseActivity<ScrapsInputViewModel, ActivityScrapsInfoDefectBinding>() {

    private val adapter  = DefectImageAdapter(mutableListOf())


    override fun initView(savedInstanceState: Bundle?) {
        mViewBind.commonTitle.ivBack.clickNoRepeat { finish() }
        mViewBind.commonTitle.tvTitle.text = getString(R.string.scraps_info_input_defect)


        mViewBind.rvDefectFace.addItemDecoration( GridSpaceItemDecoration(16,false))
        mViewBind.rvDefectFace.layoutManager = GridLayoutManager(this,3)
        mViewBind.rvDefectFace.adapter = adapter

        adapter.setNewInstance(mutableListOf(
            "https://cdn.sputniknews.cn/images/101345/64/1013456427.jpg",
            "https://resource.zhoudaosh.com/homepage/wximages/20190315/2019031509233963146946091.jpg!shoudaosh_img",
            "https://ts1.cn.mm.bing.net/th/id/R-C.6b2dece3fb041462d8215886de1a2ea4?rik=lPakM7wdUWXS6Q&riu=http%3a%2f%2fcdn.sputniknews.cn%2fimages%2f07e4%2f08%2f08%2f1031930294.jpg&ehk=aIDJ%2b%2bTf5opVD%2fCzirWVKsvACFvpj8C8lFf8z7xkUV4%3d&risl=&pid=ImgRaw&r=0",
            "https://ie.bjd.com.cn/images/202102/10/60236714e4b02e24794b0c75.jpeg",
            "https://pic3.zhimg.com/v2-3cfc2b04b805080c03ceea196ab9e8fd_r.jpg?source=12a79843",
            "https://himg2.huanqiucdn.cn/attachment2010/2019/0606/08/48/20190606084844686.jpg"
        ))

        mViewBind.etDefectDropLocation.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                if (!TextUtils.isEmpty(v.text.toString())) {
                    mViewBind.etDefectDropLocation.setText(v.text.toString())
                    mViewBind.etDefectDropLocation.setSelectionEnd()
                }
            }
            false
        }

        mViewBind.etDefectName.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                if (!TextUtils.isEmpty(v.text.toString())) {
                    mViewBind.etDefectName.setText(v.text.toString())
                    mViewBind.etDefectName.setSelectionEnd()
                }
            }
            false
        }

        mViewBind.etDefectDesc.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                if (!TextUtils.isEmpty(v.text.toString())) {
                    mViewBind.etDefectDesc.setText(v.text.toString())
                    mViewBind.etDefectDesc.setSelectionEnd()
                }
            }
            false
        }

        mViewBind.btnNext.clickNoRepeat {
            ActivityUtils.startActivity(ScrapsInfoOtherActivity::class.java)
        }
    }
}