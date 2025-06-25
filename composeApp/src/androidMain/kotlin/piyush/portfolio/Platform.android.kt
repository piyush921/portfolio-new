package piyush.portfolio

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

@Composable
actual fun Modifier.onHover(
    onEnter: () -> Unit,
    onExit: () -> Unit
): Modifier = this

actual fun openUrlInNewTab(url: String) {

}

actual fun openUrl(url: String) {

}

actual fun consoleLog(message: String) {

}