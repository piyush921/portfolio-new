package piyush.portfolio

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

/*@Composable
actual fun drawableResource(name: String) : Painter {
    val context = LocalContext.current
    val resId = remember(name) {
        context.resources.getIdentifier(name, "drawable", context.packageName)
    }
    if (resId == 0) {
        error("Drawable resource not found with name: $name")
    }
    return painterResource(id = resId)
}*/
