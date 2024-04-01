package org.rask.catalog.services

import org.rask.catalog.dto.CategoryDTO
import org.rask.catalog.entities.Category
import org.rask.catalog.repositories.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CategoryService {
    @Autowired
    private lateinit var repository: CategoryRepository

    @Transactional(readOnly = true)
    fun findAll(): List<CategoryDTO> {
        val list: List<Category> = repository.findAll()
        return list.map { CategoryDTO(it) }
    }
}

