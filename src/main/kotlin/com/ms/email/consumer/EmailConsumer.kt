package com.ms.email.consumer

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class EmailConsumer {
    @RabbitListener(queues = ["\${broker.queue.email.name}"])
    fun listenEmailQueue(@Payload emailDto: EmailDto) {
        System.out.println(emailDto.emailTo)
    }
}