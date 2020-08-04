package com.lodz.android.litepaldemo.ui.normal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lodz.android.corekt.anko.bindView
import com.lodz.android.corekt.anko.toastShort
import com.lodz.android.litepaldemo.R
import com.lodz.android.litepaldemo.ui.list.NoteListAdapter
import com.lodz.android.pandora.base.activity.BaseActivity

/**
 * 普通调用
 * @author zhouL
 * @date 2020/8/4
 */
class NormalActivity : BaseActivity() {

    companion object {
        fun start(context: Context){
            val intent = Intent(context, NormalActivity::class.java)
            context.startActivity(intent)
        }
    }

    private val mContentEdit by bindView<EditText>(R.id.content_edit)
    private val mInsertBtn by bindView<Button>(R.id.insert_btn)
    private val mRecyclerView by bindView<RecyclerView>(R.id.recycler_view)
    private lateinit var mAdapter: NoteListAdapter

    override fun getLayoutId(): Int = R.layout.activity_db

    override fun findViews(savedInstanceState: Bundle?) {
        super.findViews(savedInstanceState)
        getTitleBarLayout().setTitleName(R.string.main_normal)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        mAdapter = NoteListAdapter(getContext())
        val layoutManager = LinearLayoutManager(getContext())
        layoutManager.orientation = RecyclerView.VERTICAL
        mRecyclerView.layoutManager = layoutManager
        mAdapter.onAttachedToRecyclerView(mRecyclerView)// 如果使用网格布局请设置此方法
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.adapter = mAdapter
    }

    override fun onClickBackBtn() {
        super.onClickBackBtn()
        finish()
    }

    override fun setListeners() {
        super.setListeners()

        mInsertBtn.setOnClickListener {
            val content = mContentEdit.text.toString()
            if (content.isEmpty()){
                toastShort(R.string.main_input_hint)
                return@setOnClickListener
            }
            insertData(content)
            getNoteList()
            mContentEdit.setText("")
        }

        mAdapter.setOnClickUpdateListener { bean ->
            updateData(bean.id)
            getNoteList()
        }

        mAdapter.setOnClickDeleteListener { bean ->
        //    ObjectBoxRxImpl.get().removeNote(bean).sync()
            getNoteList()
        }

    }

    private fun insertData(content: String) {



    }

    private fun updateData(id: Int) {


    }

    private fun getNoteList() {


    }
}