package piyush.portfolio.data

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import piyush.portfolio.Constants
import piyush.portfolio.domain.model.Dashboard

object DashboardApi {

    suspend fun getDashboard(): Dashboard {
        return httpClient.get("${Constants.BASE_URL}/dashboard").body()
    }
}