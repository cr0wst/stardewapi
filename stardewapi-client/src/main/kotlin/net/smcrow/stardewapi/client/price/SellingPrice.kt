package net.smcrow.stardewapi.client.price

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule

/**
 * Representation of the selling price of an item.
 */
data class SellingPrice(
    /**
     * The base price.
     */
    val base: Int,

    /**
     * The silver, or uncommon, price.
     */
    val silver: Int,

    /**
     * The gold, or rare, price.
     */
    val gold: Int
) {
    companion object {
            private val mapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())

            fun fromJson(json: String) = mapper.readValue(json, SellingPrice::class.java)!!
    }
}