package kep.workshop

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Table

data class Speaker(
    val id: String,
    val name: String,
    val company: String? = null,
    val description: String,
    val twitter: String? = null,
    val webSite: String? = null
)

object SpeakerTable : Table() {
    val id = varchar("id", 50).primaryKey()
    val name = varchar("name", 50)
    val company = varchar("company", 50).nullable()
    val description = varchar("description", 1000)
    val twitter = varchar("twitter", 50).nullable()
    val webSite = varchar("webSite", 50).nullable()
}

data class Talk(
    val id: String,
    val title: String,
    val description: String,
    val type: String = "TALK",
    val speaker: String? = null
)

object TalkTable : Table() {
    val id = varchar("id", 50).primaryKey()
    val title = varchar("title", 100)
    val description = varchar("description", 2000)
    val type = varchar("type", 10).default("TALK")
    val speaker = (varchar("speaker", 50) references SpeakerTable.id).nullable()
}

object  UserTable : IntIdTable() {
    val username = varchar("username", 50)
    val password = varchar("password", 50)
}

class User(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<User>(UserTable)

    var username by UserTable.username
    var password by UserTable.password
}