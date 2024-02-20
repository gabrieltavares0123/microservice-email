package com.ms.email.data

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface EmailRepository : JpaRepository<EmailEntity, UUID>