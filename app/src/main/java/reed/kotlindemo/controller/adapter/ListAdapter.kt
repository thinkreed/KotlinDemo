package reed.kotlindemo.controller.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import reed.kotlindemo.R
import reed.kotlindemo.model.Template
import reed.kotlindemo.model.ViewHolder
import reed.kotlindemo.mvvm.ViewGroupManager
import reed.kotlindemo.mvvm.ViewModel
import reed.kotlindemo.mvvm.viewmanagers.BaseViewManager

/**
 * Created by thinkreed on 2017/6/17.
 */

class ListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    lateinit var data: ViewModel

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is ViewHolder) {
            holder.viewGroupManager.bind(data.get(position))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return when (Template.values()[viewType]) {
            Template.ITEM_MUSIC_INFO -> ViewHolder(ViewGroupManager(parent, R.layout.item_song)
                    .add(R.id.title, BaseViewManager())
                    .add(R.id.description, BaseViewManager())
                    .add(R.id.cover, BaseViewManager()))
            else -> throw IllegalArgumentException("not support type")
        }
    }

    override fun getItemCount(): Int {
        return data.dataCount()
    }

    override fun getItemViewType(position: Int): Int {
        return data.get(position).template.ordinal
    }

    fun setViewModel(viewModel: ViewModel) {
        this.data = viewModel
    }
}
