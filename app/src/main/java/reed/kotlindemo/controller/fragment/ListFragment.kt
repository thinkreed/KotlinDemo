package reed.kotlindemo.controller.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import reed.kotlindemo.R
import reed.kotlindemo.controller.adapter.ListAdapter

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
        recyclerView?.adapter = ListAdapter()
    }

    companion object {
        val instance: ListFragment
            get() = ListFragment()
    }
}