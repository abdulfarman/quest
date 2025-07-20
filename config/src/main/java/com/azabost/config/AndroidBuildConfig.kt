package com.azabost.config

import javax.inject.Inject

class AndroidBuildConfig @Inject constructor() : Config {
    override val isDebug: Boolean = BuildConfig.DEBUG
}