package com.azabost.share.share

sealed interface ShareResult {
    object Success : ShareResult
    class Failure(val reason: Throwable) : ShareResult
}