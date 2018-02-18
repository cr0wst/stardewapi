package net.smcrow.stardewapi.client.response

/**
 * Response from the API.
 */
data class ApiResponse<E>(
        /**
         * The [Status] of the response.
         */
        val status: Status,

        /**
         * Either a list of data or a single data value retrieved based on the request.  [null] if no results found.
         */
        val data: List<E>? = null
)