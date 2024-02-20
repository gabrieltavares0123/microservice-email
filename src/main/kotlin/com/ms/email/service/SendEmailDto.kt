package com.ms.email.service

import com.ms.email.enums.StatusEmail
import jakarta.persistence.Column
import java.time.LocalDateTime
import java.util.*

data class SendEmailDto(
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