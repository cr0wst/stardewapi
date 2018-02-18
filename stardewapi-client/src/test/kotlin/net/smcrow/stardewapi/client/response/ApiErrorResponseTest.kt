package net.smcrow.stardewapi.client.response

import net.smcrow.stardewapi.client.BaseTest
import org.junit.Assert
import org.junit.Test

class ApiErrorResponseTest: BaseTest() {

    @Test
    fun shouldDeserializeJsonIntoDto() {

        val json = """
            {
                "status": "error",
                "message": "Foo bar baz"
            }
            """.trimIndent()

        val apiErrorResponse = ApiErrorResponse.fromJson(json)

        Assert.assertEquals(Status.ERROR, apiErrorResponse.status)
        Assert.assertEquals("Foo bar baz", apiErrorResponse.message)
    }
}