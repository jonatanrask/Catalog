package org.rask.catalog.repositories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.rask.catalog.tests.Factory
import org.rask.catalog.entities.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.util.Optional

@DataJpaTest
class ProductRepositoryTests {
    @Autowired
    private lateinit var productRepository: ProductRepository
    private var existingId: Long = 0
    private var notExistingId: Long = 99
    private var countTotalProducts: Long = 0
    private var product = Product()

    @BeforeEach
    @Throws(Exception::class)
    fun setUp() {
        existingId = 1L
        notExistingId = 99L
        countTotalProducts = 25L
    }
    @Test
    fun saveShouldPersistWhenIdIsNull(){
        product = Factory.createProduct()
        product.id = null

        productRepository.save(product)

        Assertions.assertNotNull(product.id)
        Assertions.assertEquals(countTotalProducts + 1, product.id)
    }
    @Test
    fun returnsNotEmptyWhenIdIsPresent(){
        val result: Optional<Product> = productRepository.findById(existingId)

        Assertions.assertNotNull(result)
    }

    @Test
    fun returnsEmptyWhenIdIsNotPresent(){
        val result: Optional<Product> = productRepository.findById(notExistingId)
        val optionalEmpty: Optional<Product> = Optional.empty()

        Assertions.assertEquals(optionalEmpty, result)
    }

    @Test
    fun deleteShouldDeleteObjectWhenIdExists(){
        productRepository.deleteById(existingId)

        val result: Optional<Product> = productRepository.findById(existingId)
        Assertions.assertFalse(result.isPresent)
    }

}