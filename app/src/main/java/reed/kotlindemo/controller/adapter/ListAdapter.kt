package reed.kotlindemo.controller.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import reed.kotlindemo.R
import reed.kotlindemo.model.Model
import reed.kotlindemo.model.Template
import reed.kotlindemo.model.ViewHolder
import reed.kotlindemo.mvvm.ViewGroupManager
import reed.kotlindemo.mvvm.viewmanagers.BaseViewManager

/**
 * Created by thinkreed on 2017/6/17.
 */

class ListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data: MutableList<Model> = ArrayList()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is ViewHolder) {
            holder.viewGroupManager.bind(data[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return when(Template.values()[viewType]) {
            Template.ITEM_MUSIC_INFO -> ViewHolder(ViewGroupManager(parent)
                    .add(R.id.title, BaseViewManager())
                    .add(R.id.description, BaseViewManager())
                    .add(R.id.cover, BaseViewManager()))
            else -> ViewHolder(ViewGroupManager(parent))
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].template.ordinal
    }

}
