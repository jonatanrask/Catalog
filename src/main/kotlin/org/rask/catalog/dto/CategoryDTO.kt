package org.rask.catalog.dto

import org.rask.catalog.entities.Category
import java.io.Serializable

class CategoryDTO : Serializable {
    private var _id: Long = 0
    private var _name: String? = null
    @Transient
    private val serialVersionUID: Long = 1L

    constructor()

    constructor(id: Long, name: String?) {
        _id = id
        _name = name
    }

    constructor(entity: Category) : this(entity.id, entity.name)

    var id: Long
        get() = _id
        set(value) {
            _id = value
        }

    var name: String?
        get() = _name
        set(value) {
            _name = value
        }

    override fun toString(): String {
        return "CategoryDTO(id=$_id, name=$_name)"
    }
}
