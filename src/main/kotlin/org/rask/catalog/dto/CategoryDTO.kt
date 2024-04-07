package org.rask.catalog.dto

import org.rask.catalog.entities.Category
import java.io.Serializable

data class CategoryDTO(
    val id: Long,
    val name: String?
) : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }

    constructor(entity: Category) : this(entity.id, entity.name)

    override fun toString(): String {
        return "CategoryDTO(id=$id, name=$name)"
    }
}
