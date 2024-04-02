package org.rask.catalog.services.exceptions

class EntityNotFoundException : RuntimeException {

    constructor(message: String?) : super(message)
    constructor() : super()
}