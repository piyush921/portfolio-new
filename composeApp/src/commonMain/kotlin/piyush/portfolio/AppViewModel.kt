package piyush.portfolio

import io.github.alexzhirkevich.compottie.LottieComposition
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.Url
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AppViewModel {

    private val _animate = MutableStateFlow<LottieComposition?>(null)
    val animate = _animate.asStateFlow()

    @OptIn(DelicateCoroutinesApi::class)
    fun loadIcon() {
        GlobalScope.launch {
            val composition =
                LottieCompositionSpec.Companion.Url(url = "https://lottie.host/fc0a6552-62b7-4c96-806e-1012e1a9d21c/laicAPPDNl.json")
                    .load()
            withContext(Dispatchers.Main) {
                _animate.value = composition
            }
        }
    }
}