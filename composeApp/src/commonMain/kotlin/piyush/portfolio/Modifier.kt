package piyush.portfolio

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun Modifier.onHover(
    onEnter: () -> Unit,
    onExit: () -> Unit
): Modifier