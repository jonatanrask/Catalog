package org.rask.catalog.entities

import jakarta.persistence.*
import java.io.Serializable
import kotlin.jvm.Transient

@Entity
@Table(name ="tb_category")
class Category : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long = 0
    private var name: String? = null

    @Transient
    private val serialVersionUID: Long = 1L

    constructor()

    constructor(id: Long, name: String?) {
        this.id = id
        this.name = name
    }

    constructor(entity: Category) {
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Category

        if (id != other.id) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (name?.hashCode() ?: 0)
        return result
    }

}