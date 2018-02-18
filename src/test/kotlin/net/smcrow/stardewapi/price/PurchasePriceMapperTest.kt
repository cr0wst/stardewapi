package net.smcrow.stardewapi.price

import net.smcrow.stardewapi.EntityMapperBaseTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class PurchasePriceMapperTest(): EntityMapperBaseTest() {

    lateinit var purchasePriceMapper: PurchasePriceMapper

    @Before
    override fun before() {
        super.before()
        purchasePriceMapper = PurchasePriceMapper()
    }

    @Test
    fun shouldMapEntityToDtoCorrectly() {
        val entity = createPurchasePriceEntity()
        val dto = purchasePriceMapper.toDto(entity)

        Assert.assertEquals(entity.store, dto.store)
        Assert.assertEquals(entity.price, dto.price)
    }

    @Test
    fun shouldMapDtoToEntityCorrectly() {
        val dto = createPurchasePriceDto()
        val entity = purchasePriceMapper.toEntity(dto)

        Assert.assertEquals(dto.store, entity.store)
        Assert.assertEquals(dto.price, entity.price)
    }
}