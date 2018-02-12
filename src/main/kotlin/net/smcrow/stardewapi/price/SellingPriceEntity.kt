package net.smcrow.stardewapi.price

import javax.persistence.Column
import javax.persistence.Embeddable

/**
 * Representation of the selling price of a [Crop] or [Fish].
 */
@Embeddable
internal class SellingPriceEntity(
        /**
         * The base price.
         */
        @Column(name = "base_price")
        val base: Int,

        /**
         * The silver, or uncommon, price.
         */
        @Column(name = "silver_price")
        val silver: Int,

        /**
         * The gold, or rare, price.
         */
        @Column(name = "gold_price")
        val gold: Int
)