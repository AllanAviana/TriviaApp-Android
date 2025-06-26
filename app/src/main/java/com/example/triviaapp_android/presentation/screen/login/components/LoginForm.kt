package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.triviaapp_android.R
import com.example.triviaapp_android.presentation.UIStates.login.LoginUIState
import com.example.triviaapp_android.presentation.screen.welcome.components.LoginButton
import com.example.triviaapp_android.presentation.viewmodel.AuthViewModel

@Composable
fun LoginForm(state: LoginUIState, authViewModel: AuthViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .offset(y = (-5).dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.loginwavetop),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop,
        )

        LoginTextField(
            label        = "E-mail",
            placeholder  = "you@example.com",
            value        = state.email,
            onValueChange= authViewModel::onLoginEmail,
            modifier     = Modifier.padding(top = 64.dp)
        )

        LoginTextField(
            label        = "Password",
            placeholder  = "••••••••",
            value        = state.password,
            onValueChange= authViewModel::onLoginPass,
            modifier     = Modifier.padding(top = 42.dp)
        )

        LoginButton(
            onClick    = authViewModel::login,
            color      = Color(0xFF2CA7CE),
            colorText  = Color.White,
            text       = if (state.loading) "Signing in…" else "Sign in"
        )

        /* feedback de erro */
        state.error?.let {
            Text(it, color = Color.Red, modifier = Modifier.padding(top = 8.dp))
        }

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