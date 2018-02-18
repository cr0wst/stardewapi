package net.smcrow.stardewapi.client.crop

import net.smcrow.stardewapi.client.BaseTest
import org.junit.Assert
import org.junit.Test

class HarvestTest: BaseTest() {

    @Test
    fun shouldDeserializeJsonIntoDtoWithRecurringTime() {
        val initial = random.nextInt()
        val recurring = random.nextInt()

        val json = """
            {
                "initialTime": $initial,
                "recurringTime": $recurring
            }
            """.trimIndent()

        val dto = Harvest.fromJson(json)

        Assert.assertEquals(initial, dto.initialTime)
        Assert.assertEquals(recurring, dto.recurringTime)
    }

    @Test
    fun shouldDeserializeJsonIntoDtoWithoutRecurringTime() {
        val initial = random.nextInt()

        val json = """
            {
                "initialTime": $initial
            }
            """.trimIndent()

        val dto = Harvest.fromJson(json)

        Assert.assertEquals(initial, dto.initialTime)
        Assert.assertNull(dto.recurringTime)
    }


}