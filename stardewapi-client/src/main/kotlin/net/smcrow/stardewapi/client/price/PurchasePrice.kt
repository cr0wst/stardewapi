package net.smcrow.stardewapi.client.price

import net.smcrow.stardewapi.client.constants.Store


/**
 * Representation of the purchase price of a various item.
 */
class PurchasePrice(
        val store: Store,
        val price: Int
)