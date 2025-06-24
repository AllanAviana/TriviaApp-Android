package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale
import com.example.triviaapp_android.R
import com.example.triviaapp_android.presentation.viewmodel.TriviaViewModel

@Composable
fun PointsSection(
    points: Int,
    category: String,
    triviaViewModel: TriviaViewModel,
    onReturnClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(id = R.drawable.resultwavefooter),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            contentScale = ContentScale.Crop
        )

        Text(
            text = "Earned Points:",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(top = 32.dp),
            textAlign = TextAlign.Center
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
        ){
            Text(
                text = "$points",
                color = Color.White,
                fontSize = 48.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 64.dp)
                    .align(Alignment.TopCenter),
                textAlign = TextAlign.Center
            )

            Image(
                painter = painterResource(id = R.drawable.coin),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 64.dp, end = 120.dp)
                    .size(40.dp)
                    .align(Alignment.Center),
                contentScale = ContentScale.Crop
            )
        }

        Button(
            onClick = {
                onReturnClick()
                triviaViewModel.updateStatistics(points, category)
            },
            modifier = Modifier
                .padding(top = 64.dp)
                .fillMaxWidth(0.5f)
                .height(52.dp)
                .align(Alignment.Center),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color.White)
        ) {
            Text(
                text = "return",
                color = Color(0xFF00546F),
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
