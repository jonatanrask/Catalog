package org.rask.catalog.entities

import jakarta.persistence.*
import java.io.Serializable
import java.time.Instant

@Entity
@Table(name = "tb_product")
class Product : Serializable {
    @field:Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var _id: Long? = null
    @field:Column(name = "name")
    private var _name: String? = null
    @field:Column(name = "description", columnDefinition = "TEXT")
    private var _description: String? = null
    @field:Column(name = "price")
    private var _price: Double? = null
    @field:Column(name = "img_url")
    private var _imgUrl: String? = null

    @field:Column(name = "created_at" ,columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private var _createdAt: Instant? = null

    @field:Column(name = "updated_at" ,columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private var _updatedAt: Instant? = null

    @ManyToMany
    @JoinTable(name = "tb_product_category",
        joinColumns = arrayOf(JoinColumn(name = "product_id")),
        inverseJoinColumns = arrayOf(JoinColumn(name = "category_id")))
    val _categories: MutableSet<Category> = HashSet()


    companion object {
        private const val serialVersionUID = 1L
    }

    constructor()

    constructor(entity: Product) {
        _id = entity.id
        _name = entity.name
        _description = entity.description
        _price = entity.price
        _imgUrl = entity.imgUrl
    }

    constructor(id: Long?, name: String?, description: String?, price: Double?, imgUrl: String?) {
        _id = id
        _name = name
        _description = description
        _price = price
        _imgUrl = imgUrl
    }

    var id: Long?
        get() = _id
        set(value) {
            _id = value
        }

    var name: String?
        get() = _name
        set(value) {
            _name = value
        }

    var description: String?
        get() = _description
        set(value) {
            _description = value
        }

    var price: Double?
        get() = _price
        set(value) {
            _price = value
        }

    var imgUrl: String?
        get() = _imgUrl
        set(value) {
            _imgUrl = value
        }

    val categories: MutableSet<Category>
        get() = _categories


    var createdAt: Instant?
        get() = _createdAt
        set(value) {
            _createdAt = value
        }

    var updatedAt: Instant?
        get() = _updatedAt
        set(value) {
            _updatedAt = value
        }

    @PrePersist
    fun prePersist(){
        this.createdAt = Instant.now()
    }

    @PreUpdate
    fun preUpdate(){
        this.updatedAt = Instant.now()
    }
}