package com.ms.email.dto

import java.util.UUID

data class EmailDto(
    val userId: UUID,
    val emailTo: String,
    val subject: String,
    val text: String,
)
