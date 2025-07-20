package com.azabost.share.share

interface ShareSender {
    fun share(text: String): ShareResult
}