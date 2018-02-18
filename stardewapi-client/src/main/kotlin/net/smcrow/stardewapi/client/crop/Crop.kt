package net.smcrow.stardewapi.client.crop

import net.smcrow.stardewapi.client.price.PurchasePrice
import net.smcrow.stardewapi.client.price.SellingPrice

/**
 * The representation of a crop.
 */
data class Crop(
        /**
         * The id number, which can be useful when pulling information from the API endpoint.
         */
        val id: Long?,

        /**
         * The name of the crop.
         */
        val name: String,

        /**
         * The in-game description of the crop.
         */
        val description: String,

        /**
         * Data object containing [Harvest] information.
         */
        val harvest: Harvest,

        /**
         * Data object containing [SellingPrice] information.
         */
        val sellingPrice: SellingPrice,

        /**
         * [true] if the crop can be giant when planted in a 3-by-3 grid.
         */
        val canBeGiant: Boolean = false,

        /**
         * A [List] of [PurchasePrice] data objcets which represent the various locations the item can be bought.
         */
        val prices: List<PurchasePrice>
)