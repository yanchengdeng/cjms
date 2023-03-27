package com.sgm.cjms.ui

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.KeyboardUtils
import com.sgm.cjms.R
import com.sgm.cjms.base.BaseActivity
import com.sgm.cjms.data.Curb
import com.sgm.cjms.databinding.ActivityCurbListBinding
import com.sgm.cjms.databinding.ActivityScrapsListBinding
import com.sgm.cjms.ui.adapter.CurbListAdapter
import com.sgm.cjms.util.SpacesItemDecoration
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel

/**
 * @Author: yancheng
 * @Date: 2023/3/27 13:38
 * @Description:遏制任务列表
 */
class CurbListActivity : BaseActivity<BaseViewModel, ActivityCurbListBinding>() {

    private val adapter = CurbListAdapter(mutableListOf())

    override fun initView(savedInstanceState: Bundle?) {


        mViewBind.commonTitle.tvTitle.text = getString(R.string.curb_task_list)
        mViewBind.commonTitle.ivBack.setOnClickListener { finish() }

        val itemDecoration = SpacesItemDecoration(this)
        itemDecoration.setParam(android.R.color.transparent, 16)
        mViewBind.refreshView.recyclerView.addItemDecoration(itemDecoration)
        mViewBind.refreshView.recyclerView.layoutManager = LinearLayoutManager(this)
        mViewBind.refreshView.recyclerView.adapter = adapter


        //下拉刷新  走网络验证数据 - 和本地对比后再显示
        mViewBind.refreshView.refreshLayout.setOnRefreshListener {
            mViewBind.refreshView.refreshLayout.finishRefresh()
        }

        //搜索功能
        mViewBind.etSearch.setOnEditorActionListener { text, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                KeyboardUtils.hideSoftInput(mViewBind.etSearch)
                searchDataByType(text.text.toString())
            }
            false
        }

        searchDataByType()

    }


    //根据类型查找数据
    private fun searchDataByType(key: String = "") {
        adapter.setNewInstance(
            mutableListOf(
                Curb("fsdf$key"),
                Curb("fsdf$key"),
                Curb("fsdf$key"),
                Curb("fsdf$key"),
                Curb("fsdf$key"),
                Curb("fsdf$key"),
                Curb("fsdf$key"),
                Curb("fsdf$key"),
                Curb("fsdf$key"),
                Curb("fsdf$key"),
                Curb("fsdf$key"),
            )
        )
    }
}