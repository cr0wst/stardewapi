package net.smcrow.stardewapi.crop

import net.smcrow.stardewapi.EntityMapperBaseTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
internal class HarvestMapperTest(): EntityMapperBaseTest() {

    lateinit var harvestMapper: HarvestMapper

    @Before
    fun before() {
        harvestMapper = HarvestMapper()
    }

    @Test
    fun shouldMapEntityToDtoCorrectly() {
        val entity = createHarvestEntity()
        val dto = harvestMapper.toDto(entity)

        Assert.assertEquals(entity.initialTime, dto.initialTime)
        Assert.assertEquals(entity.recurringTime, dto.recurringTime)
    }

    @Test
    fun shouldMapDtoToEntityCorrectly() {
        val dto = createHarvestDto()
        val entity = harvestMapper.toEntity(dto)

        Assert.assertEquals(dto.initialTime, entity.initialTime)
        Assert.assertEquals(dto.recurringTime, entity.recurringTime)
    }
}