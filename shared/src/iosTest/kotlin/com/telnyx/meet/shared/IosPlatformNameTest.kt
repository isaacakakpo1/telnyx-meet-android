package com.telnyx.meet.shared

import kotlin.test.Test
import kotlin.test.assertEquals

class IosPlatformNameTest {
    @Test
    fun iosActualReportsIos() {
        assertEquals("iOS", platformName())
    }
}
