package net.smcrow.stardewapi.client.response

class ApiResponse<E>(
        val status: Status,
        val data: List<E>? = null
)