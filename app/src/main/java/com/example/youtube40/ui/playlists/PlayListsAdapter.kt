package com.example.youtube40.ui.playlists

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube40.R
import com.example.youtube40.databinding.ItemPlaylistsBinding
import com.example.youtube40.extentions.loadImage
import com.example.youtube40.model.Item

class PlayListsAdapter(private var items: List<Item>,private val context: Context,private val listener: ClickOnItem) :
    RecyclerView.Adapter<PlayListsAdapter.Holder>() {

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemPlaylistsBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun bind(playlists: Item,context: Context) {
            if (playlists.snippet?.thumbnails?.high?.url != null) {
                context.loadImage(playlists.snippet.thumbnails.high.url,binding.itemPlaylists)
                binding.tvPlaylistTitle.text = playlists.snippet.title
                binding.tvVideoCount.text = "${playlists.contentDetails!!.itemCount}  video series"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_playlists, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position], context)
        holder.itemView.setOnClickListener {
            listener.clickOnItem(items[position])
        }

    }

    override fun getItemCount(): Int = items.size
}