package domain.repository

import domain.model.Profile
import kotlin.uuid.Uuid

interface ProfileCommandsRepository {
    suspend fun saveProfile(profile: Profile): Boolean
    suspend fun deleteProfile(id: Uuid): Boolean
    suspend fun purgeDeleted(): Int
}