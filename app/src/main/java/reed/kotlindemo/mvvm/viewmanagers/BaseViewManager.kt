package reed.kotlindemo.mvvm.viewmanagers

import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import reed.kotlindemo.model.Model
import reed.kotlindemo.mvvm.ViewManager

/**
 * Created by thinkreed on 2017/6/17.
 */

class BaseViewManager : ViewManager() {

    override fun bind(model: Model) {

        when (view) {

            is TextView -> {
                val tv = view as TextView
                tv.text = model.title
            }

            is ImageView -> {
                val img = view as ImageView
                Picasso.with(view?.context).load(model.uri).into(img)
            }
        }
    }
}