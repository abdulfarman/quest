package com.azabost.time.api

interface NowProvider {
    fun now(): Long
}