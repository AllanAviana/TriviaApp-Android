
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
import com.example.triviaapp_android.R

@Composable
        fun LastPlayedCard(modifier: Modifier = Modifier){
            Row(
                modifier = modifier
                    .width(352.dp)
                    .height(221.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color(0xFF00A5EC)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Sports",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 16.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.field),
                    contentDescription = null,
                    modifier = Modifier
                        .width(157.dp)
                        .height(240.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }