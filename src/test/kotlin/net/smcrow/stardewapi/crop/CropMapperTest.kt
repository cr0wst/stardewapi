package net.smcrow.stardewapi.crop

import net.smcrow.stardewapi.EntityMapperBaseTest
import net.smcrow.stardewapi.price.PurchasePriceMapper
import net.smcrow.stardewapi.price.SellingPriceMapper
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class CropMapperTest(): EntityMapperBaseTest() {

    lateinit var cropMapper: CropMapper

    @Before
    override fun before() {
        super.before()
        cropMapper = CropMapper(HarvestMapper(), PurchasePriceMapper(), SellingPriceMapper())
    }

    @Test
    fun shouldMapEntityToDtoCorrectly() {
        val entity = createCropEntity()
        val dto = cropMapper.toDto(entity)

        // Single-Level Assertions
        Assert.assertEquals(entity.name, dto.name)
        Assert.assertEquals(entity.description, dto.description)
        Assert.assertEquals(entity.canBeGiant, dto.canBeGiant)

        // Nested Assertions
        Assert.assertEquals(entity.harvestEntity.initialTime, dto.harvest.initialTime)
        Assert.assertEquals(entity.harvestEntity.recurringTime, dto.harvest.recurringTime)

        Assert.assertEquals(entity.sellingPriceEntity.base, dto.sellingPrice.base)
        Assert.assertEquals(entity.sellingPriceEntity.silver, dto.sellingPrice.silver)
        Assert.assertEquals(entity.sellingPriceEntity.gold, dto.sellingPrice.gold)

        Assert.assertEquals(entity.priceEntities.size, dto.prices.size)

        entity.priceEntities.forEachIndexed { index, purchasePriceEntity ->
            Assert.assertEquals(purchasePriceEntity.price, dto.prices[index].price)
            Assert.assertEquals(purchasePriceEntity.store, dto.prices[index].store)
        }
    }

    @Test
    fun shouldMapDtoToEntityCorrectly() {
        val dto = createCropDto()
        val entity = cropMapper.toEntity(dto)

        // Single-Level Assertions
        Assert.assertEquals(dto.name, entity.name)
        Assert.assertEquals(dto.description, entity.description)
        Assert.assertEquals(dto.canBeGiant, entity.canBeGiant)

        // Nested Assertions
        Assert.assertEquals(dto.harvest.initialTime, entity.harvestEntity.initialTime)
        Assert.assertEquals(dto.harvest.recurringTime, entity.harvestEntity.recurringTime)

        Assert.assertEquals(dto.sellingPrice.base, entity.sellingPriceEntity.base)
        Assert.assertEquals(dto.sellingPrice.silver, entity.sellingPriceEntity.silver)
        Assert.assertEquals(dto.sellingPrice.gold, entity.sellingPriceEntity.gold)

        Assert.assertEquals(dto.prices.size, entity.priceEntities.size)

        dto.prices.forEachIndexed { index, purchasePrice ->
            Assert.assertEquals(purchasePrice.price, entity.priceEntities[index].price)
            Assert.assertEquals(purchasePrice.store, entity.priceEntities[index].store)
        }
    }
}