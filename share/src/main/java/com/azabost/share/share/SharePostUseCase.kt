package com.azabost.share.share

import com.azabost.analytics.Analytics
import com.azabost.analytics.AnalyticsEvent
import com.azabost.common_logger.Logger
import com.azabost.logging.logging.create
import javax.inject.Inject

class SharePostUseCase @Inject constructor(
    private val shareSender: ShareSender,
    private val analytics: Analytics,
    loggerFactory: Logger.Factory,
) {
    private val logger by lazy { loggerFactory.create(this::class) }

    fun execute(post: Post) {
        val text = "${post.title}\n\n${post.body}"
        val shareResult = shareSender.share(text)
        when (shareResult) {
            ShareResult.Success -> analytics.logEvent(AnalyticsEvent.POST_SHARED)
            is ShareResult.Failure -> logger.error("Failed to share post", shareResult.reason)
        }
    }
}