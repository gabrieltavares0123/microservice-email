package com.ms.email.data

import com.ms.email.enums.StatusEmail
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "email")
class EmailEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val emailId: UUID? = null,
    val userId: UUID,
    val emailFrom: String,
    val emailTo: String,
    val subject: String,
    @Column(columnDefinition = "TEXT")
    val text: String,
    val sendDate: LocalDateTime,
    val statusEmail: StatusEmail,
)