package net.smcrow.stardewapi.client.crop

import net.smcrow.stardewapi.client.price.PurchasePrice
import net.smcrow.stardewapi.client.price.SellingPrice

class Crop(
        val id: Long?,
        val name: String,
        val description: String,
        val harvest: Harvest,
        val sellingPrice: SellingPrice,
        val canBeGiant: Boolean = false,
        val prices: List<PurchasePrice>
)