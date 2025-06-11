import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun PlayCard(
    modifier: Modifier = Modifier,
    title: String = "Sports",
    totalQuestions: Int = 132,
    image: Int,
    navigateToDifficultySelection: () -> Unit,
    updateCategory: () -> Unit
) {
    Box(
        modifier = modifier
            .size(width = 140.dp, height = 220.dp)
            .clip(RoundedCornerShape(2.dp))
            .background(Color(0xFF1FA8E8))
            .clickable {
                navigateToDifficultySelection()
                updateCategory()
            }
    ) {
        if (image == R.drawable.pokebola) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(169.dp)
                    .offset(x = -20.dp)
                    .align(Alignment.TopStart)
            )
        } else {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(135.dp)
                    .height(185.dp)
                    .align(Alignment.TopStart)
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 8.dp, bottom = 24.dp)
        ) {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = "$totalQuestions questions",
                fontSize = 13.sp,
                color = Color.White
            )
        }
    }
}