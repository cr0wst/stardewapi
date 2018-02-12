package net.smcrow.stardewapi.crop

import net.smcrow.stardewapi.EntityMapper
import net.smcrow.stardewapi.client.crop.Crop
import net.smcrow.stardewapi.price.PurchasePriceMapper
import net.smcrow.stardewapi.price.SellingPriceMapper
import org.springframework.stereotype.Component

@Component
internal class CropMapper(val harvestMapper: HarvestMapper,
                 val purchasePriceMapper: PurchasePriceMapper,
                 val sellingPriceMapper: SellingPriceMapper
): EntityMapper<CropEntity, Crop> {
    override fun toDto(entity: CropEntity) = Crop(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            harvest = harvestMapper.toDto(entity.harvestEntity),
            sellingPrice = sellingPriceMapper.toDto(entity.sellingPriceEntity),
            canBeGiant = entity.canBeGiant,
            prices = entity.priceEntities.map { purchasePriceMapper.toDto(it) }
    )

    override fun toEntity(dto: Crop) = CropEntity(
            id = dto.id,
            name = dto.name,
            description = dto.description,
            harvestEntity = harvestMapper.toEntity(dto.harvest),
            sellingPriceEntity = sellingPriceMapper.toEntity(dto.sellingPrice),
            canBeGiant = dto.canBeGiant,
            priceEntities = dto.prices.map { purchasePriceMapper.toEntity(it)}
    )
}