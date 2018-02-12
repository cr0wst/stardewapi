package net.smcrow.stardewapi.seeding

import net.smcrow.stardewapi.client.constants.Store
import net.smcrow.stardewapi.crop.CropEntity
import net.smcrow.stardewapi.crop.CropRepository
import net.smcrow.stardewapi.crop.HarvestEntity
import net.smcrow.stardewapi.price.PurchasePriceEntity
import net.smcrow.stardewapi.price.SellingPriceEntity
import org.springframework.stereotype.Component

/**
 * Seeds CropEntity entities from a CSV File.
 */
@Component
internal class CropSeeder(private val cropRepository: CropRepository): CsvSeeder()
{
    override fun seed(fileName: String) {
        getNonHeaderRows(readFile(fileName)).forEach {
            val columns = getColumns(it, '\t')
            cropRepository.save(
                    CropEntity(
                            name = columns[Columns.NAME.ordinal],
                            description = columns[Columns.DESCRIPTION.ordinal],
                            harvestEntity = HarvestEntity(
                                    initialTime = columns[Columns.HARVEST_INITIAL.ordinal].toInt(),
                                    recurringTime = columns[Columns.HARVEST_RECURRING.ordinal].toInt()
                            ),
                            sellingPriceEntity = SellingPriceEntity(
                                    base = columns[Columns.BASIC_PRICE.ordinal].toInt(),
                                    silver = columns[Columns.SILVER_PRICE.ordinal].toInt(),
                                    gold = columns[Columns.GOLD_PRICE.ordinal].toInt()),
                            canBeGiant = columns[Columns.CAN_BE_GIANT.ordinal] == "TRUE",
                            priceEntities = buildPriceList(columns)
                    )
            )
        }
    }

    private fun buildPriceList(columns: List<String>): List<PurchasePriceEntity> {
        val priceEntities: MutableList<PurchasePriceEntity> = ArrayList()

        var price: Int = columns[Columns.GENERAL_STORE.ordinal].toInt()
        if (price > 0) {
            priceEntities.add(PurchasePriceEntity(store = Store.GENERAL_STORE, price = price))
        }

        price = columns[Columns.JOJA_MART.ordinal].toInt()
        if (price > 0) {
            priceEntities.add(PurchasePriceEntity(store = Store.JOJA, price = price))
        }

        price = columns[Columns.TRAVELING_CART.ordinal].toInt()
        if (price > 0) {
            priceEntities.add(PurchasePriceEntity(store = Store.TRAVELING_CART, price = price))
        }

        price = columns[Columns.OASIS.ordinal].toInt()
        if (price > 0) {
            priceEntities.add(PurchasePriceEntity(store = Store.OASIS, price = price))
        }

        price = columns[Columns.EGG_FESTIVAL.ordinal].toInt()
        if (price > 0) {
            priceEntities.add(PurchasePriceEntity(store = Store.EGG_FESTIVAL, price = price))
        }

        return priceEntities
    }

    companion object {

        /**
         * Represents the column headers, used for sequence-based access.
         */
        private enum class Columns {
            NAME,
            DESCRIPTION,
            HARVEST_INITIAL,
            HARVEST_RECURRING,
            BASIC_PRICE,
            SILVER_PRICE,
            GOLD_PRICE,
            CAN_BE_GIANT,
            GENERAL_STORE,
            JOJA_MART,
            TRAVELING_CART,
            OASIS,
            EGG_FESTIVAL
        }
    }
}