package domain.event

import Event
import kotlin.uuid.Uuid

sealed class MembersEvent: Event {
    data class ProfileCreated(val profileId: Uuid): MembersEvent()
    data class ProfileUpdated(val profileId: Uuid): MembersEvent()
    data class ProfileDeleted(val profileId: Uuid): MembersEvent()
    data class AccountCreated(val accountId: Uuid): MembersEvent()
    data class AccountUpdated(val accountId: Uuid): MembersEvent()
    data class AccountDeleted(val accountId: Uuid): MembersEvent()
}