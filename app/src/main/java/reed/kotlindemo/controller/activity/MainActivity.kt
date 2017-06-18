package reed.kotlindemo.controller.activity

import android.support.v4.app.Fragment
import reed.kotlindemo.controller.fragment.ListFragment

class MainActivity : FragmentActivity() {

    override fun getFragment(): Fragment {
        return ListFragment.instance
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
