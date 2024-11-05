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

    private val _composition = MutableStateFlow<LottieComposition?>(null)
    val composition = _composition.asStateFlow()

    @OptIn(DelicateCoroutinesApi::class)
    fun loadIcon(url: String) {
        GlobalScope.launch {
            val composition =
                LottieCompositionSpec.Companion.Url(url = url)
                    .load()
            withContext(Dispatchers.Main) {
                _composition.value = composition
            }
        }
    }
}