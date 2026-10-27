package domain.model

import kotlin.time.Clock
import kotlin.uuid.Uuid

data class Profile (
    val id: Uuid,
    val profileName: String,
    val avatarS3Key: String,
    val handle: String,
    val role: Role,
    val bio: String,
    val status: Status,
    val interests: List<Interest>,
    val lastTimeOnline: Clock,
)