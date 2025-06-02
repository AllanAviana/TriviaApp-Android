package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviaapp_android.R

@Composable
fun LoginHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(top = 100.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column(
            modifier = Modifier.align(Alignment.CenterVertically),
        ) {
            Text(
                text = "Sign In",
                fontSize = 40.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "If you don’t have an account",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 6.dp)
            )

            Text(
                text = "Register here",
                fontSize = 16.sp,
                color = Color(0xFF1D7D9C),
                modifier = Modifier.padding(top = 2.dp)
            )
        }

        Image(
            painter = painterResource(id = R.drawable.loginimage),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(150.dp),
        )
    }
}