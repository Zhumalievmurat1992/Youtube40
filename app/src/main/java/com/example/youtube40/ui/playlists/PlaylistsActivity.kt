package com.example.youtube40.ui.playlists

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube40.R
import com.example.youtube40.base.BaseActivity
import com.example.youtube40.databinding.ActivityPlaylistsBinding
import com.example.youtube40.extentions.showMessage
import com.example.youtube40.model.Item

class PlaylistsActivity : BaseActivity<PlaylistViewModel, ActivityPlaylistsBinding>(), ClickOnItem {

    private lateinit var cld: ConnectionLiveData
    private lateinit var layout: ConstraintLayout
    private lateinit var rv: RecyclerView

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun initView() {
        super.initView()
        layout = findViewById(R.id.check_internet)
        rv = findViewById(R.id.rv)
    }

    override fun checkInternet() {
        super.checkInternet()
        cld = ConnectionLiveData(application)
        cld.observe(this) { isConnected ->
            if (isConnected) {
                layout.visibility = View.GONE
                rv.visibility = View.VISIBLE

            } else {
                layout.visibility = View.VISIBLE
                rv.visibility = View.GONE
            }
        }
    }

    override fun initViewModel() {
        super.initViewModel()

        viewModel.getPlaylists().observe(this) {
            val list = it.items as ArrayList<Item>
            binding.rv.layoutManager = LinearLayoutManager(this)
            binding.rv.adapter = PlayListsAdapter(list, this, this)

            showMessage(it.kind.toString())
        }
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistsBinding {
        return ActivityPlaylistsBinding.inflate(inflater)
    }

    override fun clickOnItem(item: Item) {
        println("-----------------")
        val intent = Intent(this, DetailsPlaylistActivity::class.java)
        intent.putExtra("Key", item.id)
        showMessage(item.id)
        startActivity(intent)
    }
}