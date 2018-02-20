package net.smcrow.stardewapi.client.price

import com.fasterxml.jackson.databind.ObjectMapper
import net.smcrow.stardewapi.client.constants.Store
import net.smcrow.stardewapi.client.crop.Crop


/**
 * Representation of the purchase price of a various item.
 */
data class PurchasePrice(
        val store: Store = Store.ABANDONED_HOUSE,
        val price: Int = 0
) {
    companion object {
        private val mapper: ObjectMapper = ObjectMapper()

        fun fromJson(json: String) = mapper.readValue(json, PurchasePrice::class.java)
    }
}