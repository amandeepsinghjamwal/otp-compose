package otp.view.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

object OtpViewDefaults {
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

    @Composable
    fun dashedOtpColors(
        selectedDashColor: Color = SelectedBorderColor,
        unselectedDashColor: Color = Color.LightGray
    ): DashedOtpColors = DashedOtpColors(
        selectedDashColor = selectedDashColor,
        unselectedDashColor = unselectedDashColor
    )

    @Composable
    fun textStyle(
        color: Color = Color.Black,
        fontSize: TextUnit = 22.sp,
        fontFamily: FontFamily? = null,
        fontWeight: FontWeight = FontWeight.Normal): OtpTextStyle = OtpTextStyle(
            fontSize = fontSize,
            color = color,
            fontFamily = fontFamily,
            fontWeight = fontWeight
        )
}

@Immutable
class OtpBoxColors internal constructor(
    val containerColor: Color,
    val selectedBoxBorderColor: Color,
    val unselectedBoxBorderColor: Color
)

@Immutable
class DashedOtpColors internal constructor(
    val selectedDashColor: Color,
    val unselectedDashColor: Color
)

@Immutable
class OtpTextStyle internal constructor(
    val color : Color,
    val fontSize: TextUnit,
    val fontFamily: FontFamily?,
    val fontWeight: FontWeight
)