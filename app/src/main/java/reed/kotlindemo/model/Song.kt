package reed.kotlindemo.model

import android.net.Uri
import java.util.*
/**
 * Created by thinkreed on 2017/6/17.
 */

data class Song(val title: String = "", val uri: Uri = Uri.EMPTY)