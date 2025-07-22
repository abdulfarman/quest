package com.azabost.common

interface Logger {
    val name: String

    fun debug(message: String)
    fun info(message: String)
    fun error(message: String, throwable: Throwable? = null)

    interface Factory {
        fun create(name: String): Logger
    }
}
