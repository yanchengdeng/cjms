package com.sgm.cjms.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.ColorUtils
import com.blankj.utilcode.util.KeyboardUtils
import com.sgm.cjms.R
import com.sgm.cjms.base.BaseActivity
import com.sgm.cjms.data.ScrapsInfo
import com.sgm.cjms.data.ScrapsListType
import com.sgm.cjms.databinding.ActivityScrapsListBinding
import com.sgm.cjms.ui.adapter.ScrapMarkListAdapter
import com.sgm.cjms.util.SpacesItemDecoration
import com.sgm.cjms.util.T
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.ext.view.clickNoRepeat

/**
 * @Author: yancheng
 * @Date: 2023/3/27 13:38
 * @Description:废料列表
 */
class ScrapsListActivity : BaseActivity<BaseViewModel,ActivityScrapsListBinding>() {

    private val adapter  = ScrapMarkListAdapter(mutableListOf())

    override fun initView(savedInstanceState: Bundle?) {


        mViewBind.commonTitle.tvTitle.text = getString(R.string.scraps_record)
        mViewBind.commonTitle.ivBack.setOnClickListener { finish() }

        val itemDecoration = SpacesItemDecoration(this)
        itemDecoration.setParam(android.R.color.transparent,16)
        mViewBind.refreshView.recyclerView.addItemDecoration(itemDecoration)
        mViewBind.refreshView.recyclerView.layoutManager = LinearLayoutManager(this)
        mViewBind.refreshView.recyclerView.adapter = adapter




        setSelectType(ScrapsListType.TOADY)

        mViewBind.btnToday.clickNoRepeat {
            setSelectType(ScrapsListType.TOADY)
        }

        mViewBind.btnAll.clickNoRepeat {
            setSelectType(ScrapsListType.ALL)
        }

        mViewBind.btnUploaded.clickNoRepeat {
            setSelectType(ScrapsListType.UPLOADED)
        }

        mViewBind.btnWaitingUpload.clickNoRepeat {
            setSelectType(ScrapsListType.WAITING)
        }

        //下拉刷新  走网络验证数据 - 和本地对比后再显示
        mViewBind.refreshView.refreshLayout.setOnRefreshListener {
            mViewBind.refreshView.refreshLayout.finishRefresh()
        }

        //搜索功能
        mViewBind.etSearch.setOnEditorActionListener { text, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH){
                KeyboardUtils.hideSoftInput(mViewBind.etSearch)
                T.toast( text.text.toString())
            }
            false
        }

    }

    /**
     * 设置选择列表类型
     */
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setSelectType(type: ScrapsListType) {
        when(type){
            ScrapsListType.TOADY ->{
                mViewBind.btnToday.setTextColor(ColorUtils.getColor(R.color.white))
                mViewBind.btnToday.background = getDrawable(R.drawable.btn_blue_small)

                mViewBind.btnAll.setTextColor(ColorUtils.getColor(R.color.black))
                mViewBind.btnAll.background = getDrawable(R.drawable.trans_black_board_bg_small)

                mViewBind.btnUploaded.setTextColor(ColorUtils.getColor(R.color.black))
                mViewBind.btnUploaded.background = getDrawable(R.drawable.trans_black_board_bg_small)

                mViewBind.btnWaitingUpload.setTextColor(ColorUtils.getColor(R.color.black))
                mViewBind.btnWaitingUpload.background = getDrawable(R.drawable.trans_black_board_bg_small)

            }
            ScrapsListType.ALL ->{
                mViewBind.btnToday.setTextColor(ColorUtils.getColor(R.color.black))
                mViewBind.btnToday.background = getDrawable(R.drawable.trans_black_board_bg_small)

                mViewBind.btnAll.setTextColor(ColorUtils.getColor(R.color.white))
                mViewBind.btnAll.background = getDrawable(R.drawable.btn_blue_small)

                mViewBind.btnUploaded.setTextColor(ColorUtils.getColor(R.color.black))
                mViewBind.btnUploaded.background = getDrawable(R.drawable.trans_black_board_bg_small)

                mViewBind.btnWaitingUpload.setTextColor(ColorUtils.getColor(R.color.black))
                mViewBind.btnWaitingUpload.background = getDrawable(R.drawable.trans_black_board_bg_small)

            }
            ScrapsListType.UPLOADED ->{
                mViewBind.btnToday.setTextColor(ColorUtils.getColor(R.color.black))
                mViewBind.btnToday.background = getDrawable(R.drawable.trans_black_board_bg_small)

                mViewBind.btnAll.setTextColor(ColorUtils.getColor(R.color.black))
                mViewBind.btnAll.background = getDrawable(R.drawable.trans_black_board_bg_small)

                mViewBind.btnUploaded.setTextColor(ColorUtils.getColor(R.color.white))
                mViewBind.btnUploaded.background = getDrawable(R.drawable.btn_blue_small)

                mViewBind.btnWaitingUpload.setTextColor(ColorUtils.getColor(R.color.black))
                mViewBind.btnWaitingUpload.background = getDrawable(R.drawable.trans_black_board_bg_small)

            }
            ScrapsListType.WAITING ->{
                mViewBind.btnToday.setTextColor(ColorUtils.getColor(R.color.black))
                mViewBind.btnToday.background = getDrawable(R.drawable.trans_black_board_bg_small)

                mViewBind.btnAll.setTextColor(ColorUtils.getColor(R.color.black))
                mViewBind.btnAll.background = getDrawable(R.drawable.trans_black_board_bg_small)

                mViewBind.btnUploaded.setTextColor(ColorUtils.getColor(R.color.black))
                mViewBind.btnUploaded.background = getDrawable(R.drawable.trans_black_board_bg_small)

                mViewBind.btnWaitingUpload.setTextColor(ColorUtils.getColor(R.color.white))
                mViewBind.btnWaitingUpload.background = getDrawable(R.drawable.btn_blue_small)
            }
        }
        searchDataByType(type)
    }

    //根据类型查找数据
    private fun searchDataByType(type: ScrapsListType) {

        adapter?.setNewInstance(mutableListOf(
            ScrapsInfo("fsdf","fsdf","fsdf","fsdf","fsdf${type.name}","fsd"),
            ScrapsInfo("fsdf","fsdf","fsdf","fsdf","fsdf${type.name}","fsd"),
            ScrapsInfo("fsdf","fsdf","fsdf","fsdf","fsdf${type.name}","fsd"),
            ScrapsInfo("fsdf","fsdf","fsdf","fsdf","fsdf${type.name}","fsd"),
            ScrapsInfo("fsdf","fsdf","fsdf","fsdf","fsdf${type.name}","fsd"),
            ScrapsInfo("fsdf","fsdf","fsdf","fsdf","fsdf${type.name}","fsd"),
            ScrapsInfo("fsdf","fsdf","fsdf","fsdf","fsdf${type.name}","fsd"),
            ScrapsInfo("fsdf","fsdf","fsdf","fsdf","fsdf${type.name}","fsd"),
            ScrapsInfo("fsdf","fsdf","fsdf","fsdf","fsdf${type.name}","fsd"),
            ScrapsInfo("fsdf","fsdf","fsdf","fsdf","fsdf${type.name}","fsd"),
            ScrapsInfo("fsdf","fsdf","fsdf","fsdf","fsdf${type.name}","fsd"),
            ScrapsInfo("fsdf","fsdf","fsdf","fsdf","fsdf${type.name}","fsd"),
            ScrapsInfo("fsdf","fsdf","fsdf","fsdf","fsdf${type.name}","fsd"),

        ))
    }
}