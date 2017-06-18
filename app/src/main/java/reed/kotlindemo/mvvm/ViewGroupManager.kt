package reed.kotlindemo.mvvm

import android.util.SparseArray
import android.view.ViewGroup
import reed.kotlindemo.model.Model

/**
 * Created by thinkreed on 2017/6/17.
 */

class ViewGroupManager(val viewGroup: ViewGroup?) {

    private var children: SparseArray<ViewManager> = SparseArray()

    fun bind(model: Model) {

        (0 until children.size()).asSequence().map { index -> findChild(index).bind(model) }

    }

    fun findChild(index: Int): ViewManager {

        val viewId = children.keyAt(index)

        val childView = if (viewId == 0) viewGroup else {
            viewGroup?.findViewById(viewId)
        }

        val child = children.valueAt(index)
        child.view = childView
        child.id = viewId

        return child

    }

    fun add(id: Int, viewManager: ViewManager): ViewGroupManager {
        children.put(id, viewManager)
        return this
    }

    fun remove(id: Int) {
        children.remove(id)
    }
}
