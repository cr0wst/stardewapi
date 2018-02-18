package net.smcrow.stardewapi.client.price

import net.smcrow.stardewapi.client.BaseTest
import org.junit.Assert
import org.junit.Test

class SellingPriceTest: BaseTest() {

    @Test
    fun shouldDeserializeJsonIntoDto() {
        val base = random.nextInt()
        val silver = random.nextInt()
        val gold = random.nextInt()

        val json = """
            {
                "base": $base,
                "silver": $silver,
                "gold": $gold
            }
            """.trimIndent()

        val dto = SellingPrice.fromJson(json)

        Assert.assertEquals(base, dto.base)
        Assert.assertEquals(silver, dto.silver)
        Assert.assertEquals(gold, dto.gold)
    }
}