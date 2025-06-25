package piyush.portfolio

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

object Constants {
    const val BASE_URL = "http://localhost:8085"
}

@Composable
expect fun Modifier.onHover(
    onEnter: () -> Unit,
    onExit: () -> Unit
): Modifier

expect fun openUrlInNewTab(url: String)

expect fun openUrl(url: String)

expect fun consoleLog(message: String)