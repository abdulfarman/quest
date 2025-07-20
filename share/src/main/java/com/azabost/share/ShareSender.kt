package com.azabost.share

interface ShareSender {
    fun share(text: String): ShareResult
}