package org.rask.catalog.dto

import org.rask.catalog.entities.Category
import java.io.Serializable

class CategoryDTO : Serializable {
    private var id: Long = 0
    private var name: String? = null
    @Transient
    private val serialVersionUID: Long = 1L

    constructor()

    constructor(id: Long, name: String?) {
        this.id = id
        this.name = name
    }

    constructor(entity: Category){
        this.id = entity.getId()
        this.name = entity.getName()
    }

    fun getId(): Long {
        return id
    }

    fun getName(): String? {
        return name
    }

    private fun setId(id: Long) {
        this.id = id
    }

    private fun setName(name: String?) {
        this.name = name
    }


}