package piyush.portfolio.domain.model

data class Project(
    val id: Long,
    val image: String? = "",
    val title: String? = "",
    val url: String? = "",
    val description: String? = "",
    val showcaseUrl: String? = ""
)
