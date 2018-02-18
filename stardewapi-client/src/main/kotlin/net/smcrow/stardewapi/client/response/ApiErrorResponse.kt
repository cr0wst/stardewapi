package net.smcrow.stardewapi.client.response

import com.fasterxml.jackson.annotation.JsonInclude

/**
 * Response from the API when an error occurs.
 */
@JsonInclude(JsonInclude.Include.NON_ABSENT)
data class ApiErrorResponse(
        val status: Status = Status.ERROR,
        /**
         * An optional message explaining what caused the error.
         */
        val message: String? = null,

        /**
         * An optional code for error tracking.
         */
        val code: String? = null
)