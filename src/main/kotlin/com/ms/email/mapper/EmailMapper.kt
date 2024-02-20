package com.ms.email.mapper

import com.ms.email.consumer.EmailDto
import com.ms.email.service.SendEmailDto

fun EmailDto.toSendEmailDto() = SendEmailDto(
    userId = this.userId,
    emailTo = this.emailTo,
    subject = this.subject,
    text = this.text,
)