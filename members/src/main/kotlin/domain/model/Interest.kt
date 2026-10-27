package domain.model

import kotlin.uuid.Uuid

data class Interest(
    val id: Uuid,
    val interestName: String,
    val interestDescription: String
)
