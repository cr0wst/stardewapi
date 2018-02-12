package net.smcrow.stardewapi

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
internal open class NotFoundException: RuntimeException()