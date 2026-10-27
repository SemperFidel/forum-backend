package data.entity

import org.jetbrains.exposed.v1.core.Table

object InterestEntity: Table() {
    val id = uuid("id").autoGenerate()
    val interestName = varchar("interest_name", 50)
    val interestDescription = varchar("interest_description", 255)

    val profileId = reference("profile_id", ProfileEntity.id)
}