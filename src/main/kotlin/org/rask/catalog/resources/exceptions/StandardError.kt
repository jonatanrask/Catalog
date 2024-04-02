package org.rask.catalog.resources.exceptions

import java.io.Serializable
import java.time.Instant

class StandardError : Serializable {
    private var _timeStamp: Instant? = null
    private var _status: Int = 0
    private var _error: String = ""
    private var _message: String = ""
    private var _path: String = ""
    @Transient
    private val serialVersionUID: Long = 1L


    constructor()

    var timeStamp: Instant?
        get() = _timeStamp
        set(value) {
            _timeStamp = value
        }

    var status: Int
        get() = _status
        set(value) {
            _status = value
        }

    var error: String
        get() = _error
        set(value) {
            _error = value
        }

    var message: String
        get() = _message
        set(value) {
            _message = value
        }

    var path: String
        get() = _path
        set(value) {
            _path = value
        }


}