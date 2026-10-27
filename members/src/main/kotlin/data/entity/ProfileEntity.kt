package data.entity

import org.jetbrains.exposed.v1.core.Table

object ProfileEntity: Table() {
    val id = uuid("id").autoGenerate()
    val profileName = varchar("profile_name", 50)
    val avatarS3Key = varchar("avatar_s3_key", 1024)
    val handle = varchar("handle", 50).uniqueIndex()
    val bio = text("bio")

    var accountId = reference("account_id", AccountEntity.id)
}