package org.rask.catalog

import org.rask.catalog.dto.ProductDTO
import org.rask.catalog.entities.Category
import org.rask.catalog.entities.Product
import java.time.Instant

class Factory {
    companion object {
        fun createProduct(): Product {
            var product = Product(1L, "Phone","goodPhone" , 800.0, "https://img.com/img.png")
            product.categories.add(Category(2L, "Food"))
            product.categories.add(Category(3L, "Water"))
            return product
        }

        fun createProductDTO(): ProductDTO {
            var product = createProduct()
            return ProductDTO(product, product.categories)
        }
    }
}