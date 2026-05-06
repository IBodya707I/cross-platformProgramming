package com.example.myapplicationlr6_10.data.about

import co.touchlab.kermit.Logger
import com.example.myapplicationlr6_10.parseBrowserName
import com.example.myapplicationlr6_10.parseBrowserVersion
import com.example.myapplicationlr6_10.parseLayoutEngine
import com.example.myapplicationlr6_10.parseOsName
import com.example.myapplicationlr6_10.parseOsVersion
import kotlinx.browser.window


actual class Platform actual constructor() {
    actual val osName: String
        get() = parseBrowserName(window.navigator.userAgent)
    actual val osVersion: String
        get() = parseBrowserVersion(window.navigator.userAgent)
    actual val deviceModel: String
        get() = parseOsName(window.navigator.userAgent) + " " + parseOsVersion(window.navigator.userAgent)
    actual val cpuType: String
        get() = parseLayoutEngine(window.navigator.userAgent)
    actual val screen: ScreenInfo
        get() = ScreenInfo()

    actual fun logSystemInfo() {
        Logger.d("Platform $deviceInfo")
    }
}

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class ScreenInfo actual constructor() {
    val pageWidth = window.innerWidth
    val pageHeight = window.innerHeight
    val deviceDensity = window.devicePixelRatio

    actual val width: Int
        get() = pageWidth
    actual val height: Int
        get() = pageHeight
    actual val density: Int?
        get() = deviceDensity.toInt()
}