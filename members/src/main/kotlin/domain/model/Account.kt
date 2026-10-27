package domain.model

import kotlin.uuid.Uuid

data class Account(
    val id: Uuid,
    val email: String,
    val mainProfile: Profile,
    val profiles: List<Profile>,
    val status: Status,
)
