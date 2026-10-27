package domain.repository

import domain.model.Account
import kotlin.uuid.Uuid

interface AccountCommandsRepository {
    suspend fun saveAccount(account: Account): Boolean
    suspend fun deleteAccount(id: Uuid): Boolean
    suspend fun purgeBannedAndDeleted(): Int
}