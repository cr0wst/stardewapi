package net.smcrow.stardewapi.client

import com.github.javafaker.Faker
import java.util.*

/**
 * Base Test class which provides some common functionality.
 */
abstract class BaseTest(
        var faker: Faker = Faker(),
        var random: Random = Random()
)