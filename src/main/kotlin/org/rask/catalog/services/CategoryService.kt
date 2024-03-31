package org.rask.catalog.services

import org.rask.catalog.entities.Category
import org.rask.catalog.repositories.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoryService {
    @Autowired
    private lateinit var repository: CategoryRepository

    fun findAll(): List<Category> {
     return repository.findAll()
    }
}