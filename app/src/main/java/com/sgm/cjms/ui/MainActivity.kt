package com.sgm.cjms.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.AppUtils
import com.sgm.cjms.R
import com.sgm.cjms.base.BaseActivity
import com.sgm.cjms.databinding.ActivityMainBinding
import com.sgm.cjms.ui.adapter.MainModuleAdapter
import com.sgm.cjms.ui.scrap.ScrapsInfoInputActivity
import com.sgm.cjms.util.CommonUtils
import com.sgm.cjms.util.DataResourceUtil
import com.sgm.cjms.util.SpacesItemDecoration
import com.sgm.cjms.util.T
import com.xuexiang.xupdate.easy.EasyUpdate
import com.xuexiang.xupdate.entity.UpdateEntity
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel

/**
*@Describe ：首页
*@author : yanc
*@Time : 9:56
**/
class MainActivity : BaseActivity<BaseViewModel,ActivityMainBinding>() {

    private val adapter = MainModuleAdapter(data = DataResourceUtil.initMainModules())

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun initView(savedInstanceState: Bundle?) {
        mViewBind.commonTitle.ivBack.visibility = View.GONE
        mViewBind.commonTitle.tvTitle.text = getString(R.string.main_home)

        val itemDecoration = SpacesItemDecoration(this)
        itemDecoration.setParam(android.R.color.transparent,16)
        itemDecoration.setNoShowDivider(adapter.data.size,0)

        //使用该方式添加布局导致layout_header_view 根布局失效，所以布局中额外包裹一次
        val header = LayoutInflater.from(this).inflate(R.layout.layout_header_view,null,false)
        //供应商
        header.findViewById<TextView>(R.id.tvSupplierName).setOnClickListener {
            T.toast("工艺上")
        }

        header.findViewById<TextView>(R.id.tvSupplierAddress).setOnClickListener {
            T.toast("工艺上地址")
        }

        adapter.addHeaderView(header)
        mViewBind.refreshView.recyclerView.addItemDecoration(itemDecoration)


        mViewBind.refreshView.recyclerView.layoutManager = LinearLayoutManager(this)
        mViewBind.refreshView.recyclerView.adapter = adapter


        adapter.setOnItemClickListener {_,_,positon ->
            when(positon){
                0 -> ActivityUtils.startActivity(ScrapsInfoInputActivity::class.java)
                1 ->ActivityUtils.startActivity(ScrapsListActivity::class.java)
                2 ->ActivityUtils.startActivity(CurbListActivity::class.java)
                3->ActivityUtils.startActivity(DataCacheActivity::class.java)
                4->{
                    val xupdateInfo = UpdateEntity()
                    xupdateInfo.setShowNotification(true)
                    xupdateInfo.isHasUpdate = true
                    xupdateInfo.isForce = false
                    xupdateInfo.size = 12000
                    xupdateInfo.versionCode = AppUtils.getAppVersionCode()
                    xupdateInfo.versionName = AppUtils.getAppVersionName()
                    xupdateInfo.downloadUrl = "https://file.zgxyzx.net/dadaodata.com_net.zgxyzx.aio_R4.6.2_2021120113_app_product_rk3399_shimeitai.apk"
                    xupdateInfo.updateContent = "测试"
                    EasyUpdate.checkUpdate(this, xupdateInfo)
                }

            }
        }

        mViewBind.refreshView.refreshLayout.setOnRefreshListener {

            mViewBind.refreshView.refreshLayout.finishRefresh()
        }
    }



    var currentTimeMillis = 0L
    override fun onBackPressed() {
        if (System.currentTimeMillis() - currentTimeMillis > 2000L) {
            currentTimeMillis = System.currentTimeMillis()
            T.toast(getString(R.string.exit_when_back_press))
        } else {
            super.onBackPressed()
        }
    }
}