package net.smcrow.stardewapi.price

import net.smcrow.stardewapi.EntityMapperBaseTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class SellingPriceMapperTest(): EntityMapperBaseTest() {

    lateinit var sellingPriceMapper: SellingPriceMapper

    @Before
    override fun before() {
        super.before()
        sellingPriceMapper = SellingPriceMapper()
    }

    @Test
    fun shouldMapEntityToDtoCorrectly() {
        val entity = createSellingPriceEntity()
        val dto = sellingPriceMapper.toDto(entity)

        Assert.assertEquals(entity.base, dto.base)
        Assert.assertEquals(entity.silver, dto.silver)
        Assert.assertEquals(entity.gold, dto.gold)
    }

    @Test
    fun shouldMapDtoToEntityCorrectly() {
        val dto = createSellingPriceDto()
        val entity = sellingPriceMapper.toEntity(dto)

        Assert.assertEquals(dto.base, entity.base)
        Assert.assertEquals(dto.silver, entity.silver)
        Assert.assertEquals(dto.gold, entity.gold)
    }
}