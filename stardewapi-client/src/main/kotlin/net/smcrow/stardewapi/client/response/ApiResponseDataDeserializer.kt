package net.smcrow.stardewapi.client.response

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import net.smcrow.stardewapi.client.crop.Crop

/**
 * Custom deserializer for the [ApiResponse] data property.  Due to JSend compliance this property is sometimes passed
 * as a json array (with a plural property key) and sometimes as a single object (with a singular property key.
 *
 * Additionally, the [ApiResponse] object defines the contents of the list using generics, which Jackson has a hard
 * time with.
 */
class ApiResponseDataDeserializer : JsonDeserializer<Any>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext?): Any {
        val jsonNode: JsonNode = p.readValueAsTree()
        val key = jsonNode.fields().next().key
        when (key) {
            // TODO: Remove reliance on toString as it's poor form.
            "crop" -> return listOf(Crop.fromJson(jsonNode.get("crop").toString()))
            "crops" -> return buildMultipleCropsList(jsonNode.get("crops"))
        }

        throw DataNodeNotDetectedException(key)
    }

    private fun buildMultipleCropsList(node: JsonNode): List<Crop> {
        val list: MutableList<Crop> = mutableListOf()
        node.forEach {
            // TODO: Remove reliance on toString as it's poor form.
            list.add(Crop.fromJson(it.toString()))
        }

        return list
    }
}