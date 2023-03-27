package com.sgm.cjms.ui.scrap

import android.os.Bundle
import android.text.TextUtils
import android.view.inputmethod.EditorInfo
import com.blankj.utilcode.util.ActivityUtils
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.BottomListPopupView
import com.lxj.xpopup.interfaces.OnSelectListener
import com.sgm.cjms.R
import com.sgm.cjms.base.BaseActivity
import com.sgm.cjms.data.ScrapsMarkType
import com.sgm.cjms.databinding.ActivityScrapsInfoInputBinding
import com.sgm.cjms.ext.setSelectionEnd
import com.sgm.cjms.ui.viewmodle.ScrapsInputViewModel
import com.sgm.cjms.util.T
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.ext.view.clickNoRepeat

/**
 * @Author: yancheng
 * @Date: 2023/3/22 23:57
 * @Description:废料录入
 */
class ScrapsInfoInputActivity :
    BaseActivity<ScrapsInputViewModel, ActivityScrapsInfoInputBinding>() {

    private var selectedPop: BottomListPopupView? = null

    override fun initView(savedInstanceState: Bundle?) {
        mViewBind.commonTitle.ivBack.clickNoRepeat { finish() }
        mViewBind.commonTitle.tvTitle.text = getString(R.string.scraps_info_input)
        initListener()
    }

    private fun showSelectedPop(
        type: ScrapsMarkType,
        baseCode: String = "",
        workShop: String = "",
        prodLine: String = "",
        partNo: String = ""
    ) {
        selectedPop = XPopup.Builder(this).asBottomList(
            transScrapsMarkTypeToTip(type),
            getDataByScrapsMarkTye(), null, 1
        ) { position, text ->
            T.toast(text)
        }
        selectedPop?.show()
    }


    private fun getSelectedPosition() : Int{
        return 0
    }
    private fun getDataByScrapsMarkTye() : Array<String>{
        return arrayOf("测试一", "测试二", "测试三")
    }

    private fun transScrapsMarkTypeToTip(type: ScrapsMarkType): String {
        return when (type) {
            ScrapsMarkType.BASE_CODE -> getString(R.string.tip_please_select_base_code)
            ScrapsMarkType.WORK_SHOP -> getString(R.string.tip_please_select_work_shop)
            ScrapsMarkType.PROD_LINE -> getString(R.string.tip_please_select_prod_line)
            ScrapsMarkType.PART_NO -> getString(R.string.tip_please_select_part_no)
        }
    }

    private fun initListener() {


        mViewBind.btnNext.clickNoRepeat {
            ActivityUtils.startActivity(ScrapsInfoDefectActivity::class.java)
        }

        mViewBind.etRoughCastCode.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                if (!TextUtils.isEmpty(v.text.toString())) {
                    mViewBind.etRoughCastCode.setText(v.text.toString())
                    mViewBind.etRoughCastCode.setSelectionEnd()
                }
            }
            false
        }

        mViewBind.etReadyMachineCode.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                if (!TextUtils.isEmpty(v.text.toString())) {
                    mViewBind.etReadyMachineCode.setText(v.text.toString())
                    mViewBind.etReadyMachineCode.setSelectionEnd()
                }
            }
            false
        }

        //基地选择
        mViewBind.tvBaseCode.clickNoRepeat {
            showSelectedPop(
                ScrapsMarkType.BASE_CODE,
                baseCode = mViewBind.tvBaseCode.text.toString()
            )

        }

        //车间选择
        mViewBind.tvWorkShop.clickNoRepeat {
            if (TextUtils.isEmpty(mViewBind.tvWorkShop.text.toString())) {
                T.toast(getString(R.string.tip_select_work_shop))
            } else {
                showSelectedPop(
                    ScrapsMarkType.WORK_SHOP,
                    baseCode = mViewBind.tvBaseCode.text.toString(),
                    workShop = mViewBind.tvWorkShop.text.toString()
                )
            }
        }
        //产线选择
        mViewBind.tvProdLine.clickNoRepeat {
            if (TextUtils.isEmpty(mViewBind.tvProdLine.text.toString())) {
                T.toast(getString(R.string.tip_select_prod_line))
            } else {
                showSelectedPop(
                    ScrapsMarkType.WORK_SHOP,
                    baseCode = mViewBind.tvBaseCode.text.toString(),
                    workShop = mViewBind.tvWorkShop.text.toString(),
                    prodLine = mViewBind.tvProdLine.text.toString()
                )
            }
        }

        //毛坯零件号选择
        mViewBind.tvPartNo.clickNoRepeat {
            if (TextUtils.isEmpty(mViewBind.tvPartNo.text.toString())) {
                T.toast(getString(R.string.tip_select_part_no))
            } else {
                showSelectedPop(
                    ScrapsMarkType.PART_NO,
                    baseCode = mViewBind.tvBaseCode.text.toString(),
                    workShop = mViewBind.tvWorkShop.text.toString(),
                    prodLine = mViewBind.tvProdLine.text.toString(),
                    partNo = mViewBind.tvPartNo.text.toString()
                )
            }
        }

        //扫码回调数据
        setBarCodeDataListener(object : ListerBarCodeData {
            override fun listenBarCode(code: String) {
                mViewBind.etReadyMachineCode.setText(code)
            }
        })


    }

    override fun isSupportBarcodeReader(): Boolean {
        return true
    }


}