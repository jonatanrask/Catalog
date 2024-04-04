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
    fun findAll(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "linesPerPage", defaultValue = "12") linesPerPage: Int,
        @RequestParam(value = "direction", defaultValue = "ASC") direction: String,
        @RequestParam(value = "orderBy", defaultValue = "_name") orderBy: String): ResponseEntity<Page<CategoryDTO>> {

        val pageRequest: PageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy)

        val list: Page<CategoryDTO> = this.service.findAllPaged(pageRequest)
        return ResponseEntity.ok(list)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CategoryDTO> {
        val dto: CategoryDTO = this.service.findById(id)
        return ResponseEntity.ok().body(dto)
    }

    @PostMapping
    fun insert(@RequestBody categoryDTO: CategoryDTO): ResponseEntity<CategoryDTO> {
        val dto = this.service.insert(categoryDTO)
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(categoryDTO.id).toUri()
        return ResponseEntity.created(uri).body(dto)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody categoryDTO: CategoryDTO): ResponseEntity<CategoryDTO> {
        val dto = this.service.update(id, categoryDTO)
        return ResponseEntity.ok().body(dto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<CategoryDTO> {
        this.service.delete(id)
        return ResponseEntity.noContent().build()
    }

}