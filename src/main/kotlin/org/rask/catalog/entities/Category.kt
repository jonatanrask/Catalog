package org.rask.catalog.entities

import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name ="tb_category")
class Category : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @field:Column(name = "id")
    private var _id: Long = 0
    @field:Column(name = "name")
    private var _name: String? = null

    @Transient
    private val serialVersionUID: Long = 1L

    constructor()

    constructor(id: Long, name: String?) {
        _id = id
        _name = name
    }

    constructor(entity: Category) {
        _id = entity.id
        _name = entity.name
    }

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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Category

        if (_id != other._id) return false
        if (_name != other._name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = _id.hashCode()
        result = 31 * result + (_name?.hashCode() ?: 0)
        return result
    }
}
