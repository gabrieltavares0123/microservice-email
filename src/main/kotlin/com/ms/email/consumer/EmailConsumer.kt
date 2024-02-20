package com.ms.email.consumer

import com.ms.email.mapper.toEntity
import com.ms.email.mapper.toSendEmailDto
import com.ms.email.service.SendEmailDto
import com.ms.email.service.SendEmailService
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class EmailConsumer(
    private val sendEmailService: SendEmailService,
) {
    @RabbitListener(queues = ["\${broker.queue.email.name}"])
    fun listenEmailQueue(@Payload emailDto: EmailDto) {
        val sendEmailDto = emailDto.toSendEmailDto()
        sendEmailService.sendEmail(sendEmailDto)
    }
}