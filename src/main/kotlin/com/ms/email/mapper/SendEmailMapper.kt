package com.ms.email.mapper

import com.ms.email.data.SendEmailEntity
import com.ms.email.service.SendEmailDto

fun SendEmailDto.toEntity() = SendEmailEntity(
    emailId = this.emailId,
    userId = this.userId,
    emailFrom = this.emailFrom,
    emailTo = this.emailTo,
    subject = this.subject,
    text = this.text,
    sendDate = this.sendDate,
    statusEmail = this.statusEmail,
)

fun SendEmailEntity.toDto() = SendEmailDto(
    emailId = this.emailId,
    userId = this.userId,
    emailFrom = this.emailFrom,
    emailTo = this.emailTo,
    subject = this.subject,
    text = this.text,
    sendDate = this.sendDate,
    statusEmail = this.statusEmail,
)