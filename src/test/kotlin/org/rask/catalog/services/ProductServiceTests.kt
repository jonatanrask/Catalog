package org.rask.catalog.services

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.rask.catalog.repositories.ProductRepository
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
class ProductServiceTests {
    @InjectMocks
    private val productService = ProductService()
    @Mock
    private lateinit var productRepository: ProductRepository
    private var existingId = 0L
    private var notExistingId = 0L

    @BeforeEach
    @Throws(Exception::class)
    fun setUp() {
        existingId = 1L
        notExistingId = 99L

        Mockito.doNothing().`when`(productRepository).deleteById(existingId)
        Mockito.doThrow(EmptyResultDataAccessException::class.java).`when`(productRepository).deleteById(notExistingId)

    }

    @Test
    fun deleteShouldDoNothingWhenIdExists(){
        Assertions.assertDoesNotThrow { productService.delete(existingId) }

        Mockito.verify(productRepository, Mockito.times(1)).deleteById(existingId)
    }
}