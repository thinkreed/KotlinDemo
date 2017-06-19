package reed.kotlindemo.model

import android.support.v7.widget.RecyclerView
import reed.kotlindemo.mvvm.ViewGroupManager

/**
 * Created by thinkreed on 2017/6/17.
 */

class ViewHolder(val viewGroupManager: ViewGroupManager) : RecyclerView.ViewHolder(viewGroupManager.rootView)