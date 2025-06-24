import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.triviaapp_android.R

@Composable
fun ProgressHeader(points: Int, progress: Float, total: Float, medal: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(288.dp)
            .background(Color(0xFF078AD2))
            .padding(horizontal = 16.dp)
            .padding(top = 32.dp)
            .zIndex(1f)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "TriviaApp",
                color = Color(0xFF005C8E),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
            )
            Image(
                painter = painterResource(id = R.drawable.homeappicon),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box {
                    Box(
                        modifier = Modifier
                            .size(70.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFCEE9F8))
                    )
                    Image(
                        painter = painterResource(id = medal),
                        contentDescription = null,
                        modifier = Modifier
                            .size(65.dp)
                            .align(Alignment.Center)
                            .offset(y = 10.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        .width(4.dp)
                        .height(100.dp)
                        .background(Color(0xFF035D8F))
                )
            }

            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "$points/${total.toInt()}",
                    fontSize = 12.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(end = 8.dp)
                )

                ProgressBar(
                    progress = progress,
                    modifier = Modifier.width(250.dp)
                )

                Text(
                    text = "Progress",
                    fontSize = 15.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
        }
    }

    Image(
        painter = painterResource(id = R.drawable.progresswavetop),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = (-1).dp),
        contentScale = ContentScale.Crop
    )
}


@Composable
fun ProgressBar(
    progress: Float,
    modifier: Modifier = Modifier
) {
    LinearProgressIndicator(
        progress = progress.coerceIn(0f, 1f),
        trackColor = Color(0xFFCFE8FF),
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier
            .height(34.dp)
            .clip(RoundedCornerShape(32.dp))
    )
}

