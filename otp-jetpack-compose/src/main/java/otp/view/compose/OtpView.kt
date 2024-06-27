package otp.view.compose

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OtpView(
    modifier: Modifier = Modifier,
    inputLength: Int = 4,
    otpText:(otp:String)->Unit
) {
    var enteredText by remember {
        mutableStateOf("")
    }
    BasicTextField(modifier = modifier, value = enteredText, onValueChange = {
        if (it.length <= inputLength) {
            enteredText = it
            otpText(it)
        }
    }) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            repeat(inputLength) {
                val number = when {
                    it >= enteredText.length -> ""
                    else -> enteredText[it].toString()
                }
                Column(
                    modifier = Modifier
                        .size(50.dp)
                        .border(
                            3.dp,
                            shape = AbsoluteRoundedCornerShape(10.dp),
                            color = if (it == enteredText.length) Color(0xff28B26D) else if (it == enteredText.length - 1 && it == inputLength - 1) Color(0xff28B26D) else Color.LightGray
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = number, color = Color.Black, fontSize = 24.sp)
                }
                if (it != 3) {
                    Spacer(modifier = Modifier.width(15.dp))
                }
            }
        }
    }

}