package org.rask.catalog.services

import org.rask.catalog.dto.ProductDTO
import org.rask.catalog.entities.Category
import org.rask.catalog.entities.Product
import org.rask.catalog.repositories.ProductReposity
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
    private lateinit var repository: ProductReposity

    @Transactional(readOnly = true)
    fun findAllPaged(pageRequest: Pageable): Page<ProductDTO> {
        return repository.findAll(pageRequest).map(::ProductDTO)
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): ProductDTO {
        val entity: Product = repository.findById(id)
            .orElseThrow{ ResourceNotFoundException("Product with ID $id not found") }
        return ProductDTO(entity, entity.categories)
    }

    @Transactional
    fun insert(productDTO: ProductDTO): ProductDTO {
        var entity: Product = Product()
        entity.name = productDTO.name
        entity.price = productDTO.price
        entity.imgUrl = productDTO.imgUrl
        entity.description = productDTO.description
        repository.save(entity)
        return ProductDTO(entity, entity.categories)
    }
    @Transactional
    fun update(id: Long, productDTO: ProductDTO): ProductDTO {
        try {
            val entity: Product = repository.getReferenceById(id)
            entity.name = productDTO.name
            entity.price = productDTO.price
            entity.imgUrl = productDTO.imgUrl
            entity.description = productDTO.description
            repository.save(entity)
            return ProductDTO(entity, entity.categories)
        }
        catch (e: JpaObjectRetrievalFailureException) {
            throw ResourceNotFoundException("Product with ID $id not found")
        }
    }

    fun delete(id: Long) {
        try {
            repository.deleteById(id)
        }
        catch (e: DataIntegrityViolationException) {
            throw DatabaseException("Data error occurred while trying to delete a product! $e");
        }
    }


}