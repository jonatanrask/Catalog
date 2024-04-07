package org.rask.catalog.services

import org.rask.catalog.dto.ProductDTO
import org.rask.catalog.entities.Product
import org.rask.catalog.repositories.CategoryRepository
import org.rask.catalog.repositories.ProductRepository
import org.rask.catalog.services.exceptions.DatabaseException
import org.rask.catalog.services.exceptions.ResourceNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService {
    @Autowired
    private lateinit var productRepository: ProductRepository
    @Autowired
    private lateinit var categoryRepository: CategoryRepository

    @Transactional(readOnly = true)
    fun findAllPaged(pageRequest: Pageable): Page<ProductDTO> {
        return productRepository.findAll(pageRequest).map(::ProductDTO)
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): ProductDTO {
        val entity: Product = productRepository.findById(id)
            .orElseThrow{ ResourceNotFoundException("Product with ID $id not found") }
        return ProductDTO(entity, entity.categories)
    }

    @Transactional
    fun insert(productDTO: ProductDTO): ProductDTO {
        var entity = Product()
        copyCategoryDTOToEntity(productDTO, entity)
        productRepository.save(entity)
        return ProductDTO(entity, entity.categories)
    }
    @Transactional
    fun update(id: Long, productDTO: ProductDTO): ProductDTO {
        try {
            val entity: Product = productRepository.getReferenceById(id)
            copyCategoryDTOToEntity(productDTO, entity)
            productRepository.save(entity)
            return ProductDTO(entity, entity.categories)
        }
        catch (e: JpaObjectRetrievalFailureException) {
            throw ResourceNotFoundException("Product with ID $id not found")
        }
    }

    fun delete(id: Long) {
        try {
            productRepository.deleteById(id)
        }
        catch (e: DataIntegrityViolationException) {
            throw DatabaseException("Data error occurred while trying to delete a product! $e");
        }
    }

    private fun copyCategoryDTOToEntity(productDTO: ProductDTO, entity: Product) {
        entity.name = productDTO.name
        entity.description = productDTO.description
        entity.imgUrl = productDTO.imgUrl
        entity.price = productDTO.price

        entity.categories.clear()
        for (categoryDTO in productDTO.categories) {
            val category = categoryRepository.getReferenceById(categoryDTO.id)
            entity.categories.add(category)
        }
    }



}