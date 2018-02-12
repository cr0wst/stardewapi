package net.smcrow.stardewapi

internal interface EntityMapper<E, D> {
    fun toDto(entity: E): D
    fun toEntity(dto: D): E
}