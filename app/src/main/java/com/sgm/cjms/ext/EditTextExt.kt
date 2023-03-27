package com.sgm.cjms.ext

import android.text.Editable
import android.text.Selection
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.EditText

/**
 * author: yancheng
 * created on: 2022/10/1 23:58
 * description: 输入框  扩展
 */

/**
 * 输入框文本监听
 */
fun EditText.addTextListener(inputResult: (text: String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?) {
            if (!TextUtils.isEmpty(s.toString())) {
                inputResult.invoke(s.toString())
            }
        }
    })
}

//设置指示器 移动到最后
fun EditText.setSelectionEnd() {
    Selection.setSelection(
        this.text,
        this.text.length
    )
}