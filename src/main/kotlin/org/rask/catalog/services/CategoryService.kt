package org.rask.catalog.services

import org.rask.catalog.dto.CategoryDTO
import org.rask.catalog.entities.Category
import org.rask.catalog.repositories.CategoryRepository
import org.rask.catalog.services.exceptions.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

@Service
class CategoryService {
    @Autowired
    private lateinit var repository: CategoryRepository

    @Transactional(readOnly = true)
    fun findAll(): List<CategoryDTO> {
        val list: List<Category> = repository.findAll()
        return list.map { CategoryDTO(it) }
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): CategoryDTO {
        val obj: Optional<Category> = repository.findById(id)
        val entity: Category = obj.orElseThrow { EntityNotFoundException("Entity not found") }
        return CategoryDTO(entity)
    }

    @Transactional
    fun insert(categoryDTO: CategoryDTO): CategoryDTO {
        var entity: Category = Category()
        entity.name = categoryDTO.name
        entity = repository.save(entity)
        return CategoryDTO(entity)

    }
}

