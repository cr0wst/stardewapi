package net.smcrow.stardewapi.price

import net.smcrow.stardewapi.EntityMapperBaseTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
internal class PurchasePriceMapperTest(): EntityMapperBaseTest() {

    lateinit var purchasePriceMapper: PurchasePriceMapper

    @Before
    fun before() {
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