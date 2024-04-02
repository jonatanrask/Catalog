package org.rask.catalog.services.exceptions

class ResourceNotFoundException : RuntimeException {

    constructor(message: String?) : super(message)
    constructor() : super()
}