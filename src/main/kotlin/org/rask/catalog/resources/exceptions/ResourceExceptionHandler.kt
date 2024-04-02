package org.rask.catalog.resources.exceptions

import jakarta.servlet.http.HttpServletRequest
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
        var err: StandardError = StandardError()
        err.timeStamp = Instant.now()
        err.status = HttpStatus.NOT_FOUND.value()
        err.error = "Resource not found"
        err.message = e.message.toString()
        err.path = request.requestURI.toString()
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err)
    }
}