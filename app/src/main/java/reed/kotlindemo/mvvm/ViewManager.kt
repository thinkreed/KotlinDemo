package reed.kotlindemo.mvvm

import android.view.View
import android.view.WindowId
import reed.kotlindemo.model.Model

/**
 * Created by thinkreed on 2017/6/17.
 */

abstract class ViewManager(var id: Int = Int.MIN_VALUE, var view: View? = null) {

    abstract fun bind(model: Model)
}
