package org.rask.catalog.resources.exceptions

import jakarta.servlet.http.HttpServletRequest
import org.rask.catalog.services.exceptions.DatabaseException
import org.rask.catalog.services.exceptions.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.Instant

@ControllerAdvice
class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException::class)
    fun entityNotFound(e: ResourceNotFoundException, request: HttpServletRequest): ResponseEntity<StandardError>{
        val status: HttpStatus = HttpStatus.NOT_FOUND
        val err = StandardError()
        err.timeStamp = Instant.now()
        err.status = status.value()
        err.error = "Resource not found"
        err.message = e.message.toString()
        err.path = request.requestURI.toString()
        return ResponseEntity.status(status).body(err)
    }

    @ExceptionHandler(DatabaseException::class)
    fun database(e: DatabaseException, request: HttpServletRequest): ResponseEntity<StandardError>{
        val status: HttpStatus = HttpStatus.BAD_REQUEST
        val err = StandardError()
        err.timeStamp = Instant.now()
        err.status = status.value()
        err.error = "Resource not found"
        err.message = e.message.toString()
        err.path = request.requestURI.toString()
        return ResponseEntity.status(status).body(err)
    }
}