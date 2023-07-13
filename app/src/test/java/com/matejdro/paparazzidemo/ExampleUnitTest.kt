package com.matejdro.paparazzidemo

import androidx.compose.runtime.getValue
import app.cash.paparazzi.DeviceConfig.Companion.PIXEL_5
import app.cash.paparazzi.Paparazzi
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.android.ide.common.rendering.api.SessionParams
import com.airbnb.lottie.compose.rememberLottieComposition
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = PIXEL_5,
        theme = "android:Theme.Material.Light.NoActionBar",
        renderingMode = SessionParams.RenderingMode.SHRINK
    )

    @Test
    fun showLottie() {
        repeat(100) {
            paparazzi.snapshot {
                val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation))

                for (i in 0 until 100) {
                    LottieAnimation(
                        composition = composition,
                        progress = { i / 100f },
                    )
                }
            }
        }
    }
}
