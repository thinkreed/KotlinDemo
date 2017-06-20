package reed.kotlindemo.controller.fragment

import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import reed.kotlindemo.R
import reed.kotlindemo.component.DataFetcher
import reed.kotlindemo.controller.adapter.ListAdapter
import reed.kotlindemo.mvvm.viewmodels.SongsViewModel

/**
 * Created by thinkreed on 2017/6/17.
 */

class ListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView? = view?.findViewById(R.id.list)
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        val adapter = ListAdapter()
        val songs = SongsViewModel(adapter)
        DataFetcher.registerObserver(songs)
        adapter.setViewModel(songs)
        recyclerView?.adapter = adapter
        DataFetcher.getData(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI)
    }

    companion object {
        val instance: ListFragment
            get() = ListFragment()
    }
}