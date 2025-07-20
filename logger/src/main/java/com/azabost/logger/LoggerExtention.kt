package com.azabost.logger

import com.azabost.analytics.AnalyticsEvent
import com.azabost.common_logger.Logger
import kotlin.reflect.KClass


fun Logger.event(analyticsEvent: AnalyticsEvent) = info("event: ${analyticsEvent.key}")

fun Logger.Factory.create(kClass: KClass<*>): Logger = create(kClass.java.simpleName)