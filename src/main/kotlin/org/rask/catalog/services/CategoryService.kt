package org.rask.catalog.services

import jakarta.persistence.EntityNotFoundException
import org.rask.catalog.dto.CategoryDTO
import org.rask.catalog.entities.Category
import org.rask.catalog.repositories.CategoryRepository
import org.rask.catalog.services.exceptions.DatabaseException
import org.rask.catalog.services.exceptions.ResourceNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

@Service
class CategoryService {
    @Autowired
    private lateinit var repository: CategoryRepository

    @Transactional(readOnly = true)
    fun findAllPaged(pageRequest: PageRequest): Page<CategoryDTO> {
        val list: Page<Category> = repository.findAll(pageRequest)
        return list.map { CategoryDTO(it) }
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): CategoryDTO {
        val obj: Optional<Category> = repository.findById(id)
        val entity: Category = obj.orElseThrow { ResourceNotFoundException("Entity not found") }
        return CategoryDTO(entity)
    }

    @Transactional
    fun insert(categoryDTO: CategoryDTO): CategoryDTO {
        var entity: Category = Category()
        entity.name = categoryDTO.name
        entity = repository.save(entity)
        return CategoryDTO(entity)

    }

    @Transactional
    fun update(id: Long, categoryDTO: CategoryDTO): CategoryDTO {
        try {
            val entity: Category = repository.getReferenceById(id)
            entity.name = categoryDTO.name
            repository.save(entity)
            return CategoryDTO(entity)
        }
        catch (e: JpaObjectRetrievalFailureException) {
            throw ResourceNotFoundException("Id not found: $id")
        }
    }

    fun delete(id: Long) {
        try {
            repository.deleteById(id)
        }
        catch (e: DataIntegrityViolationException) {
            throw DatabaseException("Integrity violation")
        }

    }
}

