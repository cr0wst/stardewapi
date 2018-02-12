package net.smcrow.stardewapi.crop

import net.smcrow.stardewapi.client.crop.Crop
import net.smcrow.stardewapi.client.response.ApiResponse
import net.smcrow.stardewapi.client.response.Status
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/crops")
internal class CropController(private val cropRepository: CropRepository, private val cropMapper: CropMapper) {

    @GetMapping
    @ResponseBody
    fun index(): ApiResponse<Crop> {
        val results = cropRepository.findAll()
        return ApiResponse(
                status = Status.SUCCESS,
                data = if (results.isNotEmpty()) results.map { cropMapper.toDto(it) } else null
        )
    }

    @GetMapping("/{id}")
    @ResponseBody
    fun show(@PathVariable("id") id: Long): ApiResponse<Crop> {
        val result = cropRepository.findById(id)
        return ApiResponse(
                status = Status.SUCCESS,
                data = if (result.isPresent) listOf(cropMapper.toDto(result.get())) else null
        )
    }

    @GetMapping("/giant")
    @ResponseBody
    fun giant(): ApiResponse<Crop> {
        val results = cropRepository.findAllByCanBeGiant(true)
        return ApiResponse(
                status = Status.SUCCESS,
                data = if (results.isNotEmpty()) results.map { cropMapper.toDto(it) } else null
        )
    }

    @GetMapping("/search")
    @ResponseBody
    fun search(@RequestParam("name") name: String): ApiResponse<Crop> {
        val results = cropRepository.findByNameIgnoreCaseContaining(name)
        return ApiResponse(
                status = Status.SUCCESS,
                data = if (results.isNotEmpty()) results.map { cropMapper.toDto(it) } else null
        )
    }
}