package org.rask.catalog.dto

import org.rask.catalog.entities.Category
import org.rask.catalog.entities.Product
import java.io.Serializable
import java.time.Instant

data class ProductDTO(
    val id: Long?,
    val name: String?,
    val description: String?,
    val price: Double?,
    val imgUrl: String?,
    val createdAt: Instant?,
    var categories: List<CategoryDTO> = listOf()
) : Serializable {

    companion object {
        private const val serialVersionUID = 1L
    }

    constructor(entity: Product) : this(
        id = entity.id,
        name = entity.name,
        description = entity.description,
        price = entity.price,
        imgUrl = entity.imgUrl,
        createdAt = entity.createdAt
    )

    constructor(entity: Product, categories: Set<Category>) : this(entity) {
        this.categories = categories.map { CategoryDTO(it) }

    }
}


