package org.rask.catalog.repositories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.rask.catalog.entities.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.util.Optional

@DataJpaTest
class ProductRepositoryTests {
    @Autowired
    private lateinit var productRepository: ProductRepository;

    @Test
    fun deleteShouldDeleteObjectWhenIdExists(){
        val exintingId = 1L

        productRepository.deleteById(exintingId)

        val result: Optional<Product> = productRepository.findById(exintingId)
        Assertions.assertFalse(result.isPresent)
    }
}