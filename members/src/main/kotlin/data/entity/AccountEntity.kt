package data.entity

import org.jetbrains.exposed.v1.core.Table

object AccountEntity: Table() {
    val id = uuid("id").autoGenerate()
    val email = varchar("email", 255)

}