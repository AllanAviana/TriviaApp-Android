package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviaapp_android.R

@Composable
fun HeaderSection(){
    Text(
        text = "Quiz Result",
        color = Color.White,
        fontSize = 36.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier
            .padding(top = 60.dp)
    )

    Image(
        painter = painterResource(id = R.drawable.trophy),
        contentDescription = null,
        modifier = Modifier
            .padding(top = 32.dp)
            .size(200.dp),
    )

    Text(
        text = "Disastrous",
        color = Color.White,
        fontSize = 48.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier
            .padding(top = 20.dp)
    )

    Text(
        text = "The outcome was disastrous. Better luck next time!",
        color = Color.White,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth(0.85f),
        textAlign = TextAlign.Center
    )
}
