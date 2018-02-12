package net.smcrow.stardewapi.response

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import net.smcrow.stardewapi.client.response.ApiResponse

internal class ApiResponseSerializer: JsonSerializer<ApiResponse<Any>>() {
    override fun serialize(value: ApiResponse<Any>, gen: JsonGenerator, serializers: SerializerProvider?) {
        gen.writeStartObject()
        // Status Field
        gen.writeObjectField("status", value.status)
        // Data Field
        gen.writeFieldName("data")

        // The data field has 3 different states:
        // (1) Multiple data entries exist -> JSON Array
        // (2) Single data entry exists -> JSON Object
        // (3) No data entries exist -> null
        val data: List<Any> = value.data ?: emptyList()
        if (data.isNotEmpty()) {
            gen.writeStartObject()
            if (data.size > 1) {
                // JSend specification implies "data": { "objects": [] }
                // This is a semi-hacky way to write this generically.
                gen.writeArrayFieldStart(data.first().javaClass.simpleName.toLowerCase() + "s")
                data.forEach {
                    gen.writeObject(it)
                }
                gen.writeEndArray()
            } else {
                gen.writeObjectField(data.first().javaClass.simpleName.toLowerCase(), data.first())

            }
            gen.writeEndObject()
        } else {
            gen.writeNull()
        }
        gen.writeEndObject()
    }
}