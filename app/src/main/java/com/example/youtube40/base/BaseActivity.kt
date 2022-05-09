package com.example.youtube40.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.youtube40.extentions.lightStatusBar
import com.example.youtube40.extentions.setFullScreen

abstract class BaseActivity<VM : BaseViewModel, VB : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: VB
    protected abstract val viewModel: VM

//    protected lateinit var cld : ConnectionLiveData
//    protected lateinit var layout: ConstraintLayout

    protected abstract fun inflateViewBinding(inflater: LayoutInflater): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateViewBinding(layoutInflater)
        setContentView(binding.root)
        setFullScreen(window)
        lightStatusBar(window)

        checkInternet()
        initViewModel()
        initView()
        initListener()
    }

    open fun initView() {
//        layout = findViewById(R.id.check_internet)
    }

    open fun initListener() {}

    open fun checkInternet() {
//        cld = ConnectionLiveData(application)
//        cld.observe(this) { isConnected ->
//            if (isConnected) {
//                layout.visibility = View.GONE
//
//            } else {
//                layout.visibility = View.VISIBLE
//            }
//        }
    }

    open fun initViewModel() {}

}