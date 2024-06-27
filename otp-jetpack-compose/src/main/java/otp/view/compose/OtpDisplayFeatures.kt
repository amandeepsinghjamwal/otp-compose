package otp.view.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

object OtpBoxDefaults {
    @Composable
    fun otpBoxColors(
        containerColor: Color = Color.White,
        selectedBoxBorderColor: Color = SelectedBorderColor,
        unselectedBoxBorderColor: Color = Color.LightGray
    ): OtpBoxColors = OtpBoxColors(
        containerColor = containerColor,
        selectedBoxBorderColor = selectedBoxBorderColor,
        unselectedBoxBorderColor = unselectedBoxBorderColor
    )
}

    @Immutable
    class OtpBoxColors internal constructor(
        val containerColor: Color,
        val selectedBoxBorderColor: Color,
        val unselectedBoxBorderColor: Color
    )