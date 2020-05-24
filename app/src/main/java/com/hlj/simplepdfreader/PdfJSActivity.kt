package com.hlj.simplepdfreader

import android.os.Build
import android.os.Environment
import kotlinx.android.synthetic.main.activity_pdf.*


class PdfJSActivity : BaseActivity() {
    private val prefix = "file:///android_asset/web/viewer.html?file="

    override fun getLayoutId(): Int {
        return R.layout.activity_pdf
    }

    override fun initView() {
        super.initView()
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.allowFileAccess = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            webSettings.allowFileAccessFromFileURLs = true
            webSettings.allowUniversalAccessFromFileURLs = true
        }
    }

    override fun initData() {
        super.initData()
        val path = Environment.getExternalStorageDirectory().absolutePath + "/test.pdf"
        webView.loadUrl(prefix + path)
    }

    override fun onPause() {
        super.onPause()
        webView.pauseTimers()
    }

    override fun onResume() {
        super.onResume()
        webView.resumeTimers()
    }

    override fun onDestroy() {
        webView.destroy()
        constraint_pdf.removeAllViews()
        super.onDestroy()

    }
}