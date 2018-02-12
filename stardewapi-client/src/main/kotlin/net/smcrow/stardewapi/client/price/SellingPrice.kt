package net.smcrow.stardewapi.client.price

/**
 * Representation of the selling price of a [Crop] or [Fish].
 */
class SellingPrice(
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
)