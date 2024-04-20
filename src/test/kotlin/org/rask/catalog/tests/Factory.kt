package org.rask.catalog.tests

import org.rask.catalog.dto.ProductDTO
import org.rask.catalog.entities.Category
import org.rask.catalog.entities.Product

class Factory {
    companion object {
        fun createProduct(): Product {
            val product = Product(1L, "Phone","goodPhone" , 800.0, "https://img.com/img.png")
            product.categories.add(Category(2L, "Food"))
            product.categories.add(Category(3L, "Water"))
            return product
        }

        fun createProductDTO(): ProductDTO {
            val product = createProduct()
            return ProductDTO(product, product.categories)
        }
    }
}