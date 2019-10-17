package kep.workshop

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import io.ktor.application.Application
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.database() {
    DatabaseFactory.apply {
        initConfig()
        initData()
    }
}

object DatabaseFactory {
    fun initConfig() {
        Database.connect(hikari())
        transaction {
            SchemaUtils.create(SpeakerTable)
            SchemaUtils.create(TalkTable)
        }
    }

    fun initData() {
        transaction {
            speakers.forEach { speaker ->
                SpeakerTable.insert {
                    it[id] = speaker.id
                    it[name] = speaker.name
                    it[company] = speaker.company
                    it[description] = speaker.description
                    it[twitter] = speaker.twitter
                    it[webSite] = speaker.webSite
                }
            }
            talks.forEach { talk ->
                TalkTable.insert {
                    it[id] = talk.id
                    it[title] = talk.title
                    it[description] = talk.description
                    it[type] = talk.type
                    it[speaker] = talk.speaker
                }
            }
        }
    }

    private fun hikari(): HikariDataSource {
        val config = HikariConfig().apply {
            driverClassName = "org.h2.Driver"
            jdbcUrl = "jdbc:h2:mem:test"
            validate()
        }
        return HikariDataSource(config)
    }
}

suspend fun <T> dbQuery(block: () -> T): T =
    withContext(Dispatchers.IO) {
        transaction { block() }
    }