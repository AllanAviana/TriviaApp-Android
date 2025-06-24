import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviaapp_android.R
import com.example.triviaapp_android.presentation.UIStates.progress.ProgressCard

@Composable
fun StatsCard(card: ProgressCard) {
    val gradient = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFF00BEFA),
            Color(0xFF37C4E3)
        )
    )

    Column {
        Text(
            text = card.category,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF34A7E6),
            modifier = Modifier.padding(top = 12.dp)
        )

        Row(
            modifier = Modifier
                .padding(top = 4.dp)
                .width(374.dp)
                .height(85.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(brush = gradient)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Image(
                painter = painterResource(id = card.image),
                contentDescription = null,
                modifier = Modifier.size(60.dp)
            )

            Column {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.width(220.dp)
                ) {
                    Text(
                        "Games played",
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                    Row(
                        modifier = Modifier.width(60.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            "${card.gamePlayed}",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.width(220.dp)
                ) {
                    Text(
                        "Total score",
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                    Row(
                        modifier = Modifier.width(60.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            "${card.score}",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}