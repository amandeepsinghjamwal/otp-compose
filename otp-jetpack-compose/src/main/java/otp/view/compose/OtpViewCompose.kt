package otp.view.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 * Example usage: [Github](https://github.com/amandeepsinghjamwal/otp-compose/tree/master?tab=readme-ov-file#boxotpview)
 *
 * @param modifier modifies the applied layout
 * @param inputLength defines input length, options are [InputSizeOptions]
 * @param containerSize the size of otp box
 * @param containerSpacing spacing between containers
 * @param containerShape shape of otp box container
 * @param otpBoxColors colors applied on otp box
 * @param hideOtp hides otp on screen
 * @param textStyle style of otp text
 * @param otpText returns the entered otp text
 */
@Composable
fun BoxOtpView(
    modifier: Modifier = Modifier,
    inputLength: InputSizeOptions = InputSizeOptions.INPUT_SIZE_FOUR,
    containerSize: Dp = 45.dp,
    containerSpacing: Dp = 10.dp,
    containerShape: Shape = AbsoluteRoundedCornerShape(10.dp),
    otpBoxColors: OtpBoxColors = OtpViewDefaults.otpBoxColors(),
    textStyle: OtpTextStyle = OtpViewDefaults.textStyle(color = Color.Black, fontSize = 20.sp),
    hideOtp: Boolean = false,
    otpText: (otp: String) -> Unit
) {
    var enteredText by remember {
        mutableStateOf("")
    }
    val regex = ("^[0-9]*$").toRegex()
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        BasicTextField(
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier,
            value = enteredText,
            onValueChange = {
                if (it.length <= inputLength.size && it.matches(regex)) {
                    enteredText = it
                    otpText(it)
                }
            }) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                repeat(inputLength.size) {
                    val number = when {
                        it >= enteredText.length -> ""
                        else -> {
                            if (hideOtp) {
                                "●"
                            } else {
                                enteredText[it].toString()
                            }
                        }
                    }
                    Column(
                        modifier = Modifier
                            .size(containerSize)
                            .background(
                                color = otpBoxColors.containerColor,
                                shape = containerShape
                            )
                            .border(
                                3.dp,
                                shape = containerShape,
                                color = if (it == enteredText.length) otpBoxColors.selectedBoxBorderColor
                                else if (it == enteredText.length - 1 && it == inputLength.size - 1) otpBoxColors.selectedBoxBorderColor
                                else otpBoxColors.unselectedBoxBorderColor
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = number,
                            color = textStyle.color,
                            fontSize = textStyle.fontSize,
                            fontFamily = textStyle.fontFamily,
                            fontWeight = textStyle.fontWeight
                        )
                    }
                    if (it != inputLength.size - 1) {
                        Spacer(modifier = Modifier.width(containerSpacing))
                    }
                }
            }
        }
    }
}


/**
 * Example usage: [Github](https://github.com/amandeepsinghjamwal/otp-compose?tab=readme-ov-file#dashedotpview)
 *
 * @param modifier modifies the applied layout
 * @param inputLength defines input length, options are [InputSizeOptions]
 * @param dashWidth width of dash
 * @param dashSpacing spacing between dashes
 * @param dashColors colors applied on dashes
 * @param hideOtp hides otp on screen
 * @param textStyle style of otp text
 * @param otpText returns the entered otp text
 */
@Composable
fun DashedOtpView(
    modifier: Modifier = Modifier,
    inputLength: InputSizeOptions = InputSizeOptions.INPUT_SIZE_FOUR,
    textStyle: OtpTextStyle = OtpViewDefaults.textStyle(),
    dashSpacing: Dp = 10.dp,
    dashWidth: Dp = 40.dp,
    hideOtp: Boolean = false,
    dashColors: DashedOtpColors = OtpViewDefaults.dashedOtpColors(),
    otpText: (otp: String) -> Unit
) {
    var enteredText by remember {
        mutableStateOf("")
    }

    val regex = ("^[0-9]*$").toRegex()
    Box(modifier = modifier) {
        BasicTextField(
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier,
            value = enteredText,
            onValueChange = {
                if (it.length <= inputLength.size && it.matches(regex)) {
                    enteredText = it
                    otpText(it)
                }
            }) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                repeat(inputLength.size) {

                    val number = when {
                        it >= enteredText.length -> ""
                        else -> {
                            if (hideOtp) {
                                "●"
                            } else {
                                enteredText[it].toString()
                            }
                        }
                    }

                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = number,
                            color = textStyle.color,
                            fontSize = textStyle.fontSize,
                            fontFamily = textStyle.fontFamily,
                            fontWeight = textStyle.fontWeight
                        )
                        Box(
                            modifier = Modifier
                                .padding(top = 3.dp)
                                .width(dashWidth)
                                .height(3.dp)
                                .fillMaxWidth()
                                .background(
                                    color = if (it == enteredText.length) dashColors.selectedDashColor
                                    else if (it == enteredText.length - 1 && it == inputLength.size - 1) dashColors.selectedDashColor
                                    else dashColors.unselectedDashColor
                                )
                        )
                    }
                    if (it != inputLength.size - 1) {
                        Spacer(modifier = Modifier.width(dashSpacing))
                    }
                }
            }
        }
    }
}


