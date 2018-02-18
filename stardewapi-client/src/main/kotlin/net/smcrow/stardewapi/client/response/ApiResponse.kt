package net.smcrow.stardewapi.client.response

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.KotlinModule

/**
 * Response from the API.
 */
data class ApiResponse<out E>(
    /**
     * The [Status] of the response.
     */
    val status: Status,

    /**
     * Either a list of data or a single data value retrieved based on the request.  [null] if no results found.
     */
    @JsonDeserialize(using = ApiResponseDataDeserializer::class)
    val data: List<E>? = null
) {

    companion object {
        private val mapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())

        fun fromJson(json: String) = mapper.readValue(json, ApiResponse::class.java)
    }
}