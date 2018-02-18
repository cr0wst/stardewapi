package net.smcrow.stardewapi.client.price

import net.smcrow.stardewapi.client.constants.Store

/**
 * Representation of the purchase price of a various item.
 */
data class PurchasePrice(
        /**
         * The [Store] in which the item can be bought.
         */
        val store: Store,

        /**
         * The price to purchase the item.
         */
        val price: Int
)