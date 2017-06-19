package reed.kotlindemo.mvvm.viewmodels

import reed.kotlindemo.component.Observer
import reed.kotlindemo.controller.adapter.ListAdapter
import reed.kotlindemo.model.Model
import reed.kotlindemo.mvvm.ViewModel

/**
 * Created by thinkreed on 2017/6/19.
 */

class SongsViewModel(val adapter: ListAdapter) : ViewModel() {

    override fun notifyObserver() {
        adapter.notifyDataSetChanged()
    }
}