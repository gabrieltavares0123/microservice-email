package com.ms.email.service

import com.ms.email.data.SendEmailRepository
import com.ms.email.enums.StatusEmail
import com.ms.email.mapper.toDto
import com.ms.email.mapper.toEntity
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.MailException
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class SendEmailService(
    private val sendEmailRepository: SendEmailRepository,
    private val javaMailSender: JavaMailSender,
) {
    @Value(value = "\${spring.mail.username}")
    private lateinit var emailFrom: String

    @Transactional
    fun sendEmail(sendEmailDto: SendEmailDto): SendEmailDto {
        val sendEmailEntity = sendEmailDto.toEntity()
        val savedSendEmailDto: SendEmailDto
        try {
            sendEmailEntity.sendDate = LocalDateTime.now()
            sendEmailEntity.emailFrom = emailFrom

            val emailMessage = SimpleMailMessage()
            emailMessage.setTo(sendEmailEntity.emailTo)
            emailMessage.subject = sendEmailEntity.subject
            emailMessage.text = sendEmailEntity.text
            javaMailSender.send(emailMessage)
            sendEmailEntity.statusEmail = StatusEmail.SENT
        } catch (ex: MailException) {
            sendEmailEntity.statusEmail = StatusEmail.ERROR
        } finally {
            savedSendEmailDto = sendEmailRepository.save(sendEmailEntity).toDto()
        }

        return savedSendEmailDto
    }
}