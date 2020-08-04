package com.lodz.android.litepaldemo.ui.list

import android.content.Context
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lodz.android.corekt.anko.append
import com.lodz.android.corekt.utils.DateUtils
import com.lodz.android.litepaldemo.R
import com.lodz.android.litepaldemo.db.table.AlbumTable
import com.lodz.android.pandora.widget.rv.recycler.BaseRecyclerViewAdapter
import com.lodz.android.pandora.widget.rv.recycler.DataViewHolder

/**
 * 笔记列表适配器
 * @author zhouL
 * @date 2019/12/12
 */
class NoteListAdapter(context: Context) :BaseRecyclerViewAdapter<AlbumTable>(context){

    private var mUpdateListener: ((bean: AlbumTable) -> Unit)? = null
    private var mDeleteListener: ((bean: AlbumTable) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        DataViewHolder(getLayoutView(parent, R.layout.rv_item_note_list))

    override fun onBind(holder: RecyclerView.ViewHolder, position: Int) {
        val bean = getItem(position) ?: return
        showItem(holder as DataViewHolder, bean)
    }

    private fun showItem(holder: DataViewHolder, bean: AlbumTable) {
        holder.withView<TextView>(R.id.title_tv).text = bean.name.append(" --- ").append(bean.price).append("$")
        var content = "no songs"
        if (bean.songs.size > 0){
            content = ""
            for (song in bean.songs) {
                content = content.append(song.name).append(" --- ").append(song.album?.name).append("\n")
            }
        }
        holder.withView<TextView>(R.id.content_tv).text = content
        val date = bean.date
        holder.withView<TextView>(R.id.time_tv).text = if (date != null) DateUtils.getFormatString(DateUtils.TYPE_6, date) else ""
        holder.withView<TextView>(R.id.update_btn).setOnClickListener { mUpdateListener?.invoke(bean) }
        holder.withView<TextView>(R.id.delete_btn).setOnClickListener { mDeleteListener?.invoke(bean) }
    }

    fun setOnClickUpdateListener(listener: (bean: AlbumTable) -> Unit) {
        mUpdateListener = listener
    }

    fun setOnClickDeleteListener(listener: (bean: AlbumTable) -> Unit) {
        mDeleteListener = listener
    }
}