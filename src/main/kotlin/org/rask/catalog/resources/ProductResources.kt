package org.rask.catalog.resources

import org.rask.catalog.dto.ProductDTO
import org.rask.catalog.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort.Direction
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/products")
class ProductResources {
    @Autowired
    private lateinit var service: ProductService

    @GetMapping
    fun findAll(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "linesPerPage", defaultValue = "12") linesPerPage: Int,
        @RequestParam(value = "direction", defaultValue = "ASC") direction: String,
        @RequestParam(value = "orderBy", defaultValue = "_name") orderBy: String): ResponseEntity<Page<ProductDTO>> {
        return ResponseEntity.ok(service
            .findAllPaged(PageRequest
                .of(page, linesPerPage, Direction.valueOf(direction), orderBy)))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long): ResponseEntity<ProductDTO> {
        return ResponseEntity.ok().body(service.findById(id))
    }

    @PostMapping
    fun insert(@RequestBody productDTO: ProductDTO): ResponseEntity<ProductDTO> {
        return ResponseEntity
            .created(ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(productDTO.id).toUri())
            .body(service.insert(productDTO))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody productDTO: ProductDTO): ResponseEntity<ProductDTO> {
        return ResponseEntity.ok().body(service.update(id, productDTO))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }
}