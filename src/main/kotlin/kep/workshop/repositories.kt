package kep.workshop

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll

class SpeakerRepository {
    suspend fun findAll() = dbQuery {
        SpeakerTable.selectAll().mapNotNull { it.toSpeaker() }
    }

    suspend fun findById(speakerId: String) = dbQuery {
        SpeakerTable.select {
            SpeakerTable.id eq speakerId
        }.singleOrNull()?.toSpeaker()
    }

    private fun ResultRow.toSpeaker(): Speaker =
        Speaker(
            id = this[SpeakerTable.id],
            name = this[SpeakerTable.name],
            company = this[SpeakerTable.company],
            description = this[SpeakerTable.description],
            twitter = this[SpeakerTable.twitter],
            webSite = this[SpeakerTable.webSite]
        )
}

class TalkRepository {
    suspend fun findAll() = dbQuery {
        TalkTable.selectAll().mapNotNull { it.toTalk() }
    }

    suspend fun findById(talkId: String) = dbQuery {
        TalkTable.select {
            TalkTable.id eq talkId
        }.singleOrNull()?.toTalk()
    }

    suspend fun findByType(talkType: String?) = dbQuery {
        when {
            talkType != null -> TalkTable.select {  TalkTable.type eq talkType }
            else -> TalkTable.selectAll()
        }.mapNotNull { it.toTalk() }
    }

    private fun ResultRow.toTalk(): Talk =
        Talk(
            id = this[TalkTable.id],
            title = this[TalkTable.title],
            description = this[TalkTable.description],
            type = this[TalkTable.type],
            speaker = this[TalkTable.speaker]
        )
}

class UserRepository {
    suspend fun findAll() = dbQuery {
        User.all().toList()
    }

    suspend fun findByUsername(username: String) = dbQuery {
        User.find { UserTable.username eq username }.singleOrNull()
    }

    suspend fun check(username: String, password: String): Boolean = dbQuery {
        UserTable.select {
            (UserTable.username eq username) and
                    (UserTable.password eq password)
        }.singleOrNull() != null
    }
}