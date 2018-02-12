package net.smcrow.stardewapi.price

import com.fasterxml.jackson.annotation.JsonIgnore
import net.smcrow.stardewapi.client.constants.Store
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


/**
 * Representation of the purchase price of a various item.
 */
@Entity
internal class PurchasePriceEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @JsonIgnore
        val id: Long? = null,
        val store: Store,
        val price: Int
)