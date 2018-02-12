package net.smcrow.stardewapi.crop

import net.smcrow.stardewapi.price.PurchasePriceEntity
import net.smcrow.stardewapi.price.SellingPriceEntity
import javax.persistence.CascadeType
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
internal class CropEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val name: String,
        val description: String,
        @Embedded
        val harvestEntity: HarvestEntity,
        @Embedded
        val sellingPriceEntity: SellingPriceEntity,
        val canBeGiant: Boolean = false,
        @OneToMany(cascade = [CascadeType.ALL])
        val priceEntities: List<PurchasePriceEntity>
)