package piyush.portfolio

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import org.jetbrains.compose.resources.Font
import portfolio_new.composeapp.generated.resources.Res
import portfolio_new.composeapp.generated.resources.lato_light


@Composable
fun FontFamily.AppFont() {
FontFamily(
        Font(Res.font.lato_light)
    )
}

