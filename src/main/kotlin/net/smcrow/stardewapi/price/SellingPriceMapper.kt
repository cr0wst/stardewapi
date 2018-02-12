package net.smcrow.stardewapi.price

import net.smcrow.stardewapi.EntityMapper
import net.smcrow.stardewapi.client.price.SellingPrice
import org.springframework.stereotype.Component

@Component
internal class SellingPriceMapper: EntityMapper<SellingPriceEntity, SellingPrice> {
    override fun toDto(entity: SellingPriceEntity) = SellingPrice(
            base = entity.base,
            silver = entity.silver,
            gold = entity.gold
    )

    override fun toEntity(dto: SellingPrice) = SellingPriceEntity(
            base = dto.base,
            silver = dto.silver,
            gold = dto.gold
    )
}