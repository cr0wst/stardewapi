package net.smcrow.stardewapi

import net.smcrow.stardewapi.client.response.ApiResponse
import net.smcrow.stardewapi.seeding.CropSeeder
import net.smcrow.stardewapi.response.ApiResponseSerializer
import org.springframework.beans.factory.InitializingBean
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class StardewapiApplication {
    @Bean
    internal fun seedDummyInfo(cropSeeder: CropSeeder): InitializingBean {
        return InitializingBean {
            cropSeeder.seed("src/main/resources/data/crops.tsv")
        }
    }

    @Bean
    internal fun jacksonObjectMapperBuilderCustomizer(): Jackson2ObjectMapperBuilderCustomizer {
        return Jackson2ObjectMapperBuilderCustomizer {
            it.serializerByType(ApiResponse::class.java, ApiResponseSerializer())
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<StardewapiApplication>(*args)
        }
    }
}