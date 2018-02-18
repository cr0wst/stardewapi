package net.smcrow.stardewapi.client.response

class DataNodeNotDetectedException(
        private val key: String,
        override val message: String
        = "Data node with name '$key' was not found while attempting to deserialize ApiResponseData")
    : Exception(message)