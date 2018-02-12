package net.smcrow.stardewapi.price

import net.smcrow.stardewapi.EntityMapper
import net.smcrow.stardewapi.client.price.PurchasePrice
import org.springframework.stereotype.Component

@Component
internal class PurchasePriceMapper: EntityMapper<PurchasePriceEntity, PurchasePrice> {
    override fun toDto(entity: PurchasePriceEntity) = PurchasePrice(
            store = entity.store,
            price = entity.price
    )

    override fun toEntity(dto: PurchasePrice) = PurchasePriceEntity(
            store = dto.store,
            price = dto.price
    )
}