package org.rask.catalog.resources

import org.rask.catalog.dto.CategoryDTO
import org.rask.catalog.entities.Category
import org.rask.catalog.services.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/categories")
class CategoryResources {
    @Autowired
    private lateinit var service: CategoryService

    @GetMapping
    fun findAll(): ResponseEntity<List<CategoryDTO>> {
        val list: List<CategoryDTO> = service.findAll()
        return ResponseEntity.ok(list)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CategoryDTO> {
        val dto: CategoryDTO = service.findById(id)
        return ResponseEntity.ok().body(dto)
    }

    @PostMapping
    fun insert(@RequestBody categoryDTO: CategoryDTO): ResponseEntity<CategoryDTO> {
        val categoryDTO = service.insert(categoryDTO)
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(categoryDTO.id).toUri()
        return ResponseEntity.created(uri).body(categoryDTO)
    }

}