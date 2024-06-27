package otp.view.composable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import otp.view.composable.ui.theme.OtpComposeTheme
import otp.view.compose.OtpView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OtpComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    OtpView(modifier = Modifier.padding(innerPadding)){

                    }
                }
            }
        }
    }
}