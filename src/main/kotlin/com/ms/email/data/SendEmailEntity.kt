package com.ms.email.data

import com.ms.email.enums.StatusEmail
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "send_email")
class SendEmailEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val emailId: UUID? = null,
    var userId: UUID? = null,
    var emailFrom: String? = null,
    val emailTo: String,
    val subject: String,
    @Column(columnDefinition = "TEXT")
    val text: String,
    var sendDate: LocalDateTime? = null,
    var statusEmail: StatusEmail? = null,
)