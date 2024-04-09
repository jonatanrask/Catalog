package org.rask.catalog.resources

import org.rask.catalog.dto.CategoryDTO
import org.rask.catalog.entities.Category
import org.rask.catalog.services.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.PageRequest.*
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.Direction
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/categories")
class CategoryResources {
    @Autowired
    private lateinit var service: CategoryService

    @GetMapping
    fun findAll(pageRequest: PageRequest): ResponseEntity<Page<CategoryDTO>> {
        return ResponseEntity.ok(service.findAllPaged(pageRequest))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CategoryDTO> {
        return ResponseEntity.ok().body(service.findById(id))
    }

    @PostMapping
    fun insert(@RequestBody categoryDTO: CategoryDTO): ResponseEntity<CategoryDTO> {
        return ResponseEntity
            .created(ServletUriComponentsBuilder
                .fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(categoryDTO.id).toUri())
            .body(service.insert(categoryDTO))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody categoryDTO: CategoryDTO): ResponseEntity<CategoryDTO> {
        return ResponseEntity.ok().body(service.update(id, categoryDTO))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<CategoryDTO> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

}