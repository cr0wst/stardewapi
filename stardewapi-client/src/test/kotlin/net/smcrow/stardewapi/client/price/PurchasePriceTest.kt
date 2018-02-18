package net.smcrow.stardewapi.client.price

import net.smcrow.stardewapi.client.BaseTest
import net.smcrow.stardewapi.client.constants.Store
import org.junit.Assert
import org.junit.Test

class PurchasePriceTest: BaseTest() {

    @Test
    fun shouldDeserializeJsonIntoDto() {
        val store = Store.values()[random.nextInt(Store.values().size)]
        val price = random.nextInt()

        val json = """
            {
                "store": "${store.displayName}",
                "price": "$price"
            }
            """.trimIndent()

        val dto = PurchasePrice.fromJson(json)

        Assert.assertEquals(store, dto.store)
        Assert.assertEquals(price, dto.price)
    }
}