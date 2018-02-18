package net.smcrow.stardewapi.client.crop

import net.smcrow.stardewapi.client.BaseTest
import net.smcrow.stardewapi.client.constants.Store
import net.smcrow.stardewapi.client.price.PurchasePrice
import net.smcrow.stardewapi.client.price.SellingPrice
import org.junit.Assert
import org.junit.Test

class CropTest: BaseTest() {

    @Test
    fun shouldDeserializeJsonIntoDto() {

        // Crop Properties
        val id = random.nextLong()
        val name = faker.name().fullName()
        val description = faker.lorem().paragraph()
        val canBeGiant = random.nextBoolean()

        // Dependent Properties
        val harvest = Harvest(random.nextInt(), random.nextInt())
        val sellingPrice = SellingPrice(random.nextInt(), random.nextInt(), random.nextInt())
        val prices = generatePriceList()


        val json = """
            {
                "id": $id,
                "name": "$name",
                "description": "$description",
                "harvest": {
                    "initialTime": ${harvest.initialTime},
                    "recurringTime": ${harvest.recurringTime}
                },
                "sellingPrice": {
                    "base": ${sellingPrice.base},
                    "silver": ${sellingPrice.silver},
                    "gold": ${sellingPrice.gold}
                },
                "canBeGiant": "$canBeGiant",
                "prices": ${buildPriceJson(prices)}
            }
            """.trimIndent()

        val dto = Crop.fromJson(json)

        Assert.assertEquals(id, dto.id)
        Assert.assertEquals(name, dto.name)
        Assert.assertEquals(description, dto.description)
        Assert.assertEquals(harvest, dto.harvest)
        Assert.assertEquals(sellingPrice, dto.sellingPrice)
        Assert.assertEquals(canBeGiant, dto.canBeGiant)
        Assert.assertEquals(prices, dto.prices)
    }

    private fun generatePriceList(): List<PurchasePrice> {
        // Make sure we generate at least one.
        return List(random.nextInt(3) + 1) {
            PurchasePrice(
                    store = Store.values()[random.nextInt(Store.values().size)],
                    price = random.nextInt()
            )
        }
    }

    private fun buildPriceJson(prices: List<PurchasePrice>): String {
        val priceJson = StringBuilder()
        priceJson.append("[")

        prices.forEach {
            priceJson.append("""
            {
                "store": "${it.store.displayName}",
                "price": "${it.price}"
            },
            """.trimIndent())
        }
        // Remove the last character which will always be a trailing ,
        priceJson.deleteCharAt(priceJson.length - 1)
        priceJson.append("]")

        return priceJson.toString()
    }
}