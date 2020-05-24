package com.hlj.simplepdfreader

import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        super.initView()

        test_pdf.setOnClickListener {
            startActivity(Intent(this, PdfJSActivity::class.java))

        }
    }
}
