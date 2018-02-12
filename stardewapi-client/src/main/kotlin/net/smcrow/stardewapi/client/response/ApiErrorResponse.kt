package net.smcrow.stardewapi.client.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_ABSENT)
class ApiErrorResponse(
        val status: Status = Status.ERROR,
        val message: String? = null,
        val code: String? = null
)