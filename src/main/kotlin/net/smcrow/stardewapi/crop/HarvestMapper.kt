package net.smcrow.stardewapi.crop

import net.smcrow.stardewapi.EntityMapper
import net.smcrow.stardewapi.client.crop.Harvest
import org.springframework.stereotype.Component

@Component
internal class HarvestMapper: EntityMapper<HarvestEntity, Harvest> {
    override fun toDto(entity: HarvestEntity) = Harvest(
            initialTime = entity.initialTime,
            recurringTime = entity.recurringTime
    )

    override fun toEntity(dto: Harvest) = HarvestEntity(
            initialTime = dto.initialTime,
            recurringTime = dto.recurringTime
    )
}