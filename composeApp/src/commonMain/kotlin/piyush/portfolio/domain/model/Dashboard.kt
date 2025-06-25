package piyush.portfolio.domain.model

data class Dashboard(
    val home: Home,
    val overTheYears: OverTheYears,
    val links: Links
)

data class Home(
    val heading1: String,
    val heading2: String,
    val profileImage: String,
)

data class OverTheYears(
    val description: String
)

data class Links(
    val resume : String,
    val github : String,
    val twitter : String,
    val instagram : String,
    val linkedin : String,
)
