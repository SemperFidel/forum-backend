package domain.repository

import domain.model.Profile
import domain.model.Role
import kotlin.uuid.Uuid

interface ProfileQueriesRepository {
    suspend fun getAllProfiles(): List<Profile>
    suspend fun getAllProfilesByAccount(accountId: Uuid): List<Profile>
    suspend fun getProfileById(id: Uuid): Profile?
    suspend fun filterAllProfilesByRole(role: Role): List<Profile>
    suspend fun filterAccountProfilesByRole(accountId: Uuid, role: Role): List<Profile>
}