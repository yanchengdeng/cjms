package com.sgm.cjms.base

import android.os.Bundle
import android.util.Log
import androidx.viewbinding.ViewBinding
import com.blankj.utilcode.util.BarUtils
import com.blankj.utilcode.util.GsonUtils
import com.blankj.utilcode.util.LogUtils
import com.honeywell.aidc.*
import com.sgm.cjms.ext.dismissLoadingExt
import com.sgm.cjms.ext.showLoadingExt
import com.sgm.cjms.util.L
import com.sgm.cjms.util.T
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import me.hgj.jetpackmvvm.base.activity.BaseVmVbActivity
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel

/**
 * 描述　: 你项目中的Activity基类，在这里实现显示弹窗，吐司，还有加入自己的需求操作 ，如果不想用Databind，请继承
 * BaseVmActivity例如
 * abstract class BaseActivity<VM : BaseViewModel> : BaseVmActivity<VM>() {
 */
abstract class BaseActivity<VM : BaseViewModel, VB : ViewBinding> : BaseVmVbActivity<VM, VB>(),
    BarcodeReader.BarcodeListener,
    BarcodeReader.TriggerListener {

    //条形码读取
    private var barcodeReader: BarcodeReader? = null
    private var manager: AidcManager? = null
    //监听扫描code
    private var listerBarCodeData :ListerBarCodeData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BarUtils.setStatusBarLightMode(this, true)

    }

    override fun onResume() {
        super.onResume()
        if (isSupportBarcodeReader()) {
            initBarCodeReader()
        }

    }

    fun setBarCodeDataListener(listerBarCodeData: ListerBarCodeData){
        this.listerBarCodeData = listerBarCodeData
    }


    override fun onPause() {
        super.onPause()
        if (isSupportBarcodeReader()) {
            barcodeReader?.release()
        }
    }

    //初始化扫描管理
    private fun initBarCodeReader() {
        AidcManager.create(this) { aidcManager ->
            manager = aidcManager
            try {
                barcodeReader = manager?.createBarcodeReader()
                doListenBarcodeReader()
                barcodeReader?.claim()
            } catch (e: InvalidScannerNameException) {
                T.toast("扫描：Invalid Scanner Name Exception:${e.message}")
                L.e("扫描异常Invalid Scanner Name Exception:${e.message}")
            } catch (e: Exception) {
                T.toast("扫描${e.message}")
                L.e("扫描异常${e.message}")
            }
        }
    }

    //添加扫描配置及监听事件
    private fun doListenBarcodeReader() {
        barcodeReader?.apply {
            addBarcodeListener(this@BaseActivity)
            setProperty(
                BarcodeReader.PROPERTY_TRIGGER_CONTROL_MODE,
                BarcodeReader.TRIGGER_CONTROL_MODE_AUTO_CONTROL
            )
            addTriggerListener(this@BaseActivity)


            val properties: MutableMap<String, Any> = HashMap()
            // Set Symbologies On/Off
            properties[BarcodeReader.PROPERTY_CODE_128_ENABLED] = true
            properties[BarcodeReader.PROPERTY_GS1_128_ENABLED] = true
            properties[BarcodeReader.PROPERTY_QR_CODE_ENABLED] = true
            properties[BarcodeReader.PROPERTY_CODE_39_ENABLED] = true
            properties[BarcodeReader.PROPERTY_DATAMATRIX_ENABLED] = true
            properties[BarcodeReader.PROPERTY_UPC_A_ENABLE] = true
            properties[BarcodeReader.PROPERTY_EAN_13_ENABLED] = false
            properties[BarcodeReader.PROPERTY_AZTEC_ENABLED] = false
            properties[BarcodeReader.PROPERTY_CODABAR_ENABLED] = false
            properties[BarcodeReader.PROPERTY_INTERLEAVED_25_ENABLED] = false
            properties[BarcodeReader.PROPERTY_PDF_417_ENABLED] = false
            // Set Max Code 39 barcode length
            properties[BarcodeReader.PROPERTY_CODE_39_MAXIMUM_LENGTH] = 10
            // Turn on center decoding
            properties[BarcodeReader.PROPERTY_CENTER_DECODE] = true
            // Enable bad read response
            properties[BarcodeReader.PROPERTY_NOTIFICATION_BAD_READ_ENABLED] = true
            // Sets time period for decoder timeout in any mode
            properties[BarcodeReader.PROPERTY_DECODER_TIMEOUT] = 400
            setProperties(properties)
        }
    }

    //是否支持PDA 扫码 默认不支持
    open fun isSupportBarcodeReader(): Boolean {
        return false
    }

    abstract override fun initView(savedInstanceState: Bundle?)

    /**
     * 创建liveData观察者
     */
    override fun createObserver() {}

    /**
     * 打开等待框
     */
    override fun showLoading(message: String) {
        showLoadingExt(message)
    }

    /**
     * 关闭等待框
     */
    override fun dismissLoading() {
        dismissLoadingExt()
    }

    override fun onStop() {
        if (isSupportBarcodeReader()) {
            barcodeReader?.apply {
                removeBarcodeListener(this@BaseActivity)
                removeTriggerListener(this@BaseActivity)
                close()
            }
            manager?.apply {
                close()
            }
        }
        super.onStop()

    }


    override fun onBarcodeEvent(event: BarcodeReadEvent?) {
        if (isSupportBarcodeReader()) {
            listerBarCodeData?.listenBarCode(event?.barcodeData ?: "")
        }
    }

    override fun onFailureEvent(p0: BarcodeFailureEvent?) {
        T.toast("扫描失败，重新试试")
    }

    override fun onTriggerEvent(p0: TriggerStateChangeEvent?) {
    }


    override fun onDestroy() {
        super.onDestroy()
        dismissLoadingExt()
    }


    /**
     * 在任何情况下本来适配正常的布局突然出现适配失效，适配异常等问题，只要重写 Activity 的 getResources() 方法
     */
//    override fun getResources(): Resources {
//        AutoSizeCompat.autoConvertDensityOfGlobal(super.getResources())
//        return super.getResources()
//    }




    interface ListerBarCodeData{
        fun listenBarCode(code : String)
    }
}