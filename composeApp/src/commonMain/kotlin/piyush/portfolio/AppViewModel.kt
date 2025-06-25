package piyush.portfolio

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
import piyush.portfolio.domain.model.Dashboard
import piyush.portfolio.domain.repository.DashboardRepository

class AppViewModel: ViewModel() {

    private val _dashboardLiveData = MutableStateFlow<Dashboard?>(null)
    val dashboardLiveData = _dashboardLiveData.asStateFlow()

    init {
        getDashboard()
    }

    fun getDashboard() {

        viewModelScope.launch {
            val dashboard = DashboardRepository.fetchDashboard()
            _dashboardLiveData.emit(dashboard)
        }

    }

}