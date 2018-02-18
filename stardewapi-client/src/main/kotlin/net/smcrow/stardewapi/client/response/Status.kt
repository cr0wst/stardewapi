package net.smcrow.stardewapi.client.response

import com.fasterxml.jackson.annotation.JsonValue

/**
 * Status codes for responses.
 */
enum class Status(@JsonValue val status: String) {
    SUCCESS("success"),
    FAIL("fail"),
    ERROR("error")
}