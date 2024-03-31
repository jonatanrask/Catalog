package org.rask.catalog.repositories

import org.rask.catalog.entities.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Long> {
}