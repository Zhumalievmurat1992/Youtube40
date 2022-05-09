package com.example.youtube40.ui.playlists

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.example.youtube40.R
import com.example.youtube40.base.BaseActivity
import com.example.youtube40.databinding.ActivityDetailsPlaylistBinding
import com.example.youtube40.model.Item

class DetailsPlaylistActivity : BaseActivity<PlaylistViewModel,ActivityDetailsPlaylistBinding>(),ClickOnItem {

//    private lateinit var cld1: ConnectionLiveData
//    private lateinit var layout1: ConstraintLayout
    private lateinit var id: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_playlist)

        loadId()
    }

//    override fun initView() {
//        super.initView()
//        layout1 = findViewById(R.id.check_internet1)
//    }

//    override fun checkInternet() {
//        super.checkInternet()
//        cld1 = ConnectionLiveData(application)
//        cld1.observe(this) { isConnected ->
//            if (isConnected) {
//                layout1.visibility = View.GONE
//            } else {
//                layout1.visibility = View.VISIBLE
//            }
//        }
//    }

    private fun loadId() {
        val bundle = intent.getStringExtra("Key")
         id = bundle.toString()
        println(bundle.toString()+"------------")
        Log.d("olololo", bundle.toString())
    }

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this) [PlaylistViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityDetailsPlaylistBinding {
        return ActivityDetailsPlaylistBinding.inflate(inflater)
    }

    override fun clickOnItem(item: Item) {

    }
}