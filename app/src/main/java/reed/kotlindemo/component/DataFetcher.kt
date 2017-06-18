package reed.kotlindemo.component

import android.net.Uri
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch
import reed.kotlindemo.model.Model
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by thinkreed on 2017/6/17.
 */

object DataFetcher {

    fun getData(uri: Uri): List<Model> {
        return when (uri.scheme) {
            "http" -> getHttpData(uri)
            "file" -> getFileData(uri)
            "content" -> getContentData(uri)
            else -> emptyList()
        }
    }

    private fun getHttpData(uri: Uri): List<Model> {
        launch(CommonPool) {
            val conn = URL(uri.toString()).openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            conn.readTimeout = 5000
            conn.connectTimeout = 10000
            conn.doOutput = true

        }
        return listOf(Model())
    }

    private fun getFileData(uri: Uri): List<Model> {
        return listOf(Model())
    }

    private fun getContentData(uri: Uri): List<Model> {
        return listOf(Model())
    }

}