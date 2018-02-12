package net.smcrow.stardewapi.client.response

import com.fasterxml.jackson.annotation.JsonValue

enum class Status(@JsonValue val status: String) {
  SUCCESS("success"),
  FAIL("fail"),
  ERROR("error")
}