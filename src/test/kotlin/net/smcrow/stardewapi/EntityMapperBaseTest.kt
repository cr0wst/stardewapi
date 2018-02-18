package net.smcrow.stardewapi

import net.smcrow.stardewapi.client.constants.Store
import net.smcrow.stardewapi.client.crop.Crop
import net.smcrow.stardewapi.client.crop.Harvest
import net.smcrow.stardewapi.client.price.PurchasePrice
import net.smcrow.stardewapi.client.price.SellingPrice
import net.smcrow.stardewapi.crop.CropEntity
import net.smcrow.stardewapi.crop.HarvestEntity
import net.smcrow.stardewapi.price.PurchasePriceEntity
import net.smcrow.stardewapi.price.SellingPriceEntity
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

internal abstract class EntityMapperBaseTest : BaseTest() {

    protected fun createCropEntity() = CropEntity(
            id = faker.number().randomNumber(),
            name = faker.name().fullName(),
            description = faker.lorem().paragraph(),
            harvestEntity = createHarvestEntity(),
            sellingPriceEntity = createSellingPriceEntity(),
            canBeGiant = faker.bool().bool(),
            priceEntities = createPurchasePriceEntities()
    )

    protected fun createHarvestEntity() = HarvestEntity(
            faker.number().randomDigit(),
            faker.number().randomDigit()
    )

    protected fun createSellingPriceEntity() = SellingPriceEntity(
            faker.number().randomDigit(),
            faker.number().randomDigit(),
            faker.number().randomDigit()
    )

    protected fun createPurchasePriceEntity() = PurchasePriceEntity(
            store = Store.values()[random.nextInt(Store.values().size)],
            price = faker.number().randomDigit()
    )

    protected fun createPurchasePriceEntities() = List(random.nextInt(3)) {
        createPurchasePriceEntity()
    }

    protected fun createCropDto() = Crop(
            id = faker.number().randomNumber(),
            name = faker.name().fullName(),
            description = faker.lorem().paragraph(),
            harvest = createHarvestDto(),
            sellingPrice = createSellingPriceDto(),
            canBeGiant = faker.bool().bool(),
            prices = createPurchasePriceDtos()
    )

    protected fun createHarvestDto() = Harvest(
            faker.number().randomDigit(),
            faker.number().randomDigit()
    )

    protected fun createSellingPriceDto() = SellingPrice(
            faker.number().randomDigit(),
            faker.number().randomDigit(),
            faker.number().randomDigit()
    )

    protected fun createPurchasePriceDto() = PurchasePrice(
            store = Store.values()[random.nextInt(Store.values().size)],
            price = faker.number().randomDigit()
    )

    protected fun createPurchasePriceDtos() = List(random.nextInt(3)) {
        createPurchasePriceDto()
    }
}