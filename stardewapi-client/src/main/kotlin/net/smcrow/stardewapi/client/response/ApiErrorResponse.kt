package net.smcrow.stardewapi.client.response

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule

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
) {
    companion object {
        private val mapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())

        fun fromJson(json: String) = mapper.readValue(json, ApiErrorResponse::class.java)
    }
}