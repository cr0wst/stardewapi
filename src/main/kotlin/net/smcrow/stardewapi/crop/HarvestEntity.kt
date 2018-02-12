package net.smcrow.stardewapi.crop

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
internal class HarvestEntity(
        @Column(name = "harvest_initial")
        val initialTime: Int,

        @Column(name = "harvest_recurring")
        val recurringTime: Int? = null
)