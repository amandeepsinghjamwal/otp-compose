package otp.view.composable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import otp.view.composable.ui.theme.OtpComposeTheme
import otp.view.compose.BoxOtpView
import otp.view.compose.DashedOtpView
import otp.view.compose.InputSizeOptions
import otp.view.compose.OtpViewDefaults

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OtpComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        BoxOtpView(
                            inputLength = InputSizeOptions.INPUT_SIZE_FOUR,
                            containerSize = 45.dp,
                            containerSpacing = 10.dp,
                            modifier = Modifier
                                .padding(innerPadding),

                        ) {

                        }
                        DashedOtpView(
                            modifier = Modifier,
                            inputLength = InputSizeOptions.INPUT_SIZE_FOUR,
                            textStyle = OtpViewDefaults.textStyle(color = Color.Black),
                            dashSpacing = 12.dp,
                            dashWidth = 40.dp,
                            hideOtp = false,
                            dashColors = OtpViewDefaults.dashedOtpColors(),
                        ) {otp-> }
                    }
                }
            }
        }
    }
}