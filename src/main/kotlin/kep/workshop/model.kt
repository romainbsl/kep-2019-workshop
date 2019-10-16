package kep.workshop

data class Speaker(
    val id: String,
    val name: String,
    val company: String? = null,
    val description: String,
    val twitter: String? = null,
    val webSite: String? = null
)

data class Talk(
    val id: String,
    val title: String,
    val description: String,
    val type: String = "TALK",
    val speaker: String = ""
)