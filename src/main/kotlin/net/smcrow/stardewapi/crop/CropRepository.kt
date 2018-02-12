package net.smcrow.stardewapi.crop

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
internal interface CropRepository: JpaRepository<CropEntity, Long> {

    fun findByNameIgnoreCaseContaining(name: String): List<CropEntity>

    fun findAllByCanBeGiant(canBeGiant: Boolean): List<CropEntity>
}