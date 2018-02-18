package net.smcrow.stardewapi.client.crop

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule

/**
 * Representation of the harvest information for a [Crop].
 */
data class Harvest(
    /**
     * The initial time to harvest.
     */
    val initialTime: Int,

    /**
     * The recurring time for additional harvests, or [null] if not applicable.
     */
val recurringTime: Int? = null
) {
    companion object {
            private val mapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())

            fun fromJson(json: String) = mapper.readValue(json, Harvest::class.java)!!
    }
}