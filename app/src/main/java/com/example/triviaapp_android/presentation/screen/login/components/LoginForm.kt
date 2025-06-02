package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.triviaapp_android.R
import com.example.triviaapp_android.presentation.screen.welcome.components.LoginButton

@Composable
fun LoginForm() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .offset(x = 0.dp, y = (-5).dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.loginwavetop),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop,
        )

        LoginTextField(
            label = "Enter your user name",
            placeholder = "User name or email address",
            value = "",
            onValueChange = {},
            modifier = Modifier.padding(top = 64.dp)
        )

        LoginTextField(
            label = "Enter your user name",
            placeholder = "User name or email address",
            value = "",
            onValueChange = {},
            modifier = Modifier.padding(top = 42.dp)
        )

        LoginButton(
            onClick = {},
            color = Color(0xFF2CA7CE),
            colorText = Color.White,
        )

        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.loginwavefooter),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .offset(y = 6.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}