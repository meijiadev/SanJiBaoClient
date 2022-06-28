package com.example.sanjibaoclient.qrcode

import com.example.architecture.viewmodel.BaseViewModel
import com.example.sanjibaoclient.R
import com.example.sanjibaoclient.app.AppVmDbActivity
import com.example.sanjibaoclient.databinding.ActivityQrCodeBinding
import com.journeyapps.barcodescanner.CaptureManager

class QRCodeActivity : AppVmDbActivity<BaseViewModel, ActivityQrCodeBinding>() {

    private var capture: CaptureManager? = null

    override fun layoutId(): Int = R.layout.activity_qr_code

    override fun initView() {
        capture= CaptureManager(this,mDatabind.qrCode)
        //capture.initializeFromIntent(intent,savedIn)


    }

    override fun initData() {

    }

}