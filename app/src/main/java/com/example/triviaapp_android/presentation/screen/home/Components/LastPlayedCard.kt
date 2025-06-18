import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.triviaapp_android.presentation.UIStates.home.LastPlayedState

@Composable
fun LastPlayedCard(modifier: Modifier = Modifier, lastPlayed: LastPlayedState, played: Boolean) {
    Box(
        modifier = modifier
            .width(352.dp)
            .height(221.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(Color(0xFF00A5EC)),
        contentAlignment = Alignment.Center
    ) {
        if (played) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = lastPlayed.category,
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 16.dp)
                )

                Image(
                    painter = painterResource(id = lastPlayed.image),
                    contentDescription = null,
                    modifier = Modifier
                        .width(200.dp)
                        .height(240.dp)
                        .zIndex(1f),
                    contentScale = ContentScale.Crop
                )
            }
        } else {
            Text(
                text = "You haven't played anything yet",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 40.sp,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    }
}
