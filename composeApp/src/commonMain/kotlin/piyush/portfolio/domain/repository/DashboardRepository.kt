package piyush.portfolio.domain.repository

import piyush.portfolio.data.DashboardApi
import piyush.portfolio.domain.model.Dashboard
import piyush.portfolio.domain.model.Home
import piyush.portfolio.domain.model.Links
import piyush.portfolio.domain.model.OverTheYears

object DashboardRepository {

    suspend fun fetchDashboard(): Dashboard {
        return DashboardApi.getDashboard()
    }

}