package net.smcrow.stardewapi.client.crop

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
)