package net.smcrow.stardewapi.client.constants

import com.fasterxml.jackson.annotation.JsonValue

/**
 * The various places to purchase items.
 */
enum class Store(@JsonValue val displayName: String) {
    ABANDONED_HOUSE ("Abandoned House"),
    ADVENTURERS_GUILD ("Adventurer's Guild"),
    BLACKSMITH ("Blacksmith"),
    CARPENTERS_SHOP ("Carpenter's Shop"),
    CASINO ("Casino"),
    FISH_SHOP ("Fish Shop"),
    CLINIC ("Harvey's Clinic"),
    ICE_CREAM_STAND ("Ice Cream Stand"),
    JOJA ("JojaMart"),
    RANCH ("Marnie's Ranch"),
    OASIS ("Oasis"),
    GENERAL_STORE ("Pierre's General Store"),
    SALOON ("The Stardrop Saloon"),
    TRAVELING_CART ("Traveling Cart"),
    WIZARDS_TOWER ("Wizard's Tower"),
    EGG_FESTIVAL("Egg Festival")
}