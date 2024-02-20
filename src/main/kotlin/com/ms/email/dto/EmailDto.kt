package com.ms.email.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class EmailDto(
    @field:JsonProperty("userId") val userId: UUID,
    @field:JsonProperty("emailTo") val emailTo: String,
    @field:JsonProperty("subject") val subject: String,
    @field:JsonProperty("text") val text: String,
)
