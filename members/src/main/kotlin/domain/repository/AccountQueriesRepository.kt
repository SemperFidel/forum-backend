package domain.repository

import domain.model.Account
import domain.model.Role
import domain.model.Status
import kotlin.uuid.Uuid

interface AccountQueriesRepository {
    suspend fun getAllAccounts(): List<Account>
    suspend fun filterAccountsByStatus(status: Status): List<Account>
    suspend fun getAccountById(accountId: Uuid): Account?
}