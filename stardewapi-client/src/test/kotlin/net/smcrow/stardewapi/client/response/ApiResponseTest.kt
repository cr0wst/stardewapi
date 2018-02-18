package net.smcrow.stardewapi.client.response

import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.ObjectMapper
import net.smcrow.stardewapi.client.BaseTest
import net.smcrow.stardewapi.client.constants.Store
import net.smcrow.stardewapi.client.crop.Crop
import net.smcrow.stardewapi.client.crop.Harvest
import net.smcrow.stardewapi.client.price.PurchasePrice
import net.smcrow.stardewapi.client.price.SellingPrice
import org.junit.Assert
import org.junit.Test

class ApiResponseTest: BaseTest() {

    @Test
    fun shouldDeserializeJsonIntoDtoWithMultipleCropResponse() {
        val crops = generateCropList(2)

        // This is the same process the server uses to produce the response.
        // _Should_ be safe.
        val cropJson = ObjectMapper().writeValueAsString(crops)
        val json = """
            {
                "status": "success",
                "data": {
                    "crops" : $cropJson
                }
            }
            """.trimIndent()

        val apiResponse = ApiResponse.fromJson(json)

        Assert.assertEquals(Status.SUCCESS, apiResponse.status)
        Assert.assertEquals(crops, apiResponse.data)
    }

    @Test
    fun shouldDeserializeJsonIntoDtoWithSingleCropResponse() {
        val crop = generateCrop()

        // This is the same process the server uses to produce the response.
        // _Should_ be safe.
        val cropJson = ObjectMapper().writeValueAsString(crop)
        val json = """
            {
                "status": "success",
                "data": {
                    "crop" : $cropJson
                }
            }
            """.trimIndent()

        val apiResponse = ApiResponse.fromJson(json)

        Assert.assertEquals(Status.SUCCESS, apiResponse.status)
        Assert.assertEquals(listOf(crop), apiResponse.data)
    }

    @Test
    fun shouldThrowExceptionWhenDataNodeCannotBeDeserialized() {
        val json = """
            {
                "status": "success",
                "data": {
                    "foo": []
                }
            }
            """

        try {
            ApiResponse.fromJson(json)
            Assert.fail("Expected to throw a DataNodeNotDetectedException")
        } catch (e: JsonMappingException) {
            // Jackson wraps our exception in a JsonMappingexception.
            Assert.assertTrue(e.cause is DataNodeNotDetectedException)
        }
    }

    private fun generateCropList(size: Int): List<Crop> {
        val list: MutableList<Crop> = mutableListOf()

        repeat(size, {
            list.add(generateCrop())
        })

        return list
    }

    private fun generateCrop(): Crop {
        return Crop(
                random.nextLong(),
                faker.name().fullName(),
                faker.lorem().paragraph(),
                Harvest(random.nextInt(), random.nextInt()),
                SellingPrice(random.nextInt(), random.nextInt(), random.nextInt()),
                random.nextBoolean(),
                generatePriceList()
        )
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
}