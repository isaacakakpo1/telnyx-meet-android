package com.telnyx.meet.shared

import kotlin.test.Test
import kotlin.test.assertEquals

class AndroidPlatformNameTest {
    @Test
    fun androidActualReportsAndroid() {
        assertEquals("Android", platformName())
    }
}
