
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
        fun DividerWithText(
    modifier: Modifier = Modifier,
    text: String = "Enjoy a game",
    lineColor: Color = Color(0xFF01779C),
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(
                    color = lineColor,
                    thickness = 2.dp,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = text,
                    fontSize = 24.sp,
                    color = lineColor,
                    modifier = Modifier.padding(horizontal = 4.dp)
                )

                Divider(
                    color = lineColor,
                    thickness = 2.dp,
                    modifier = Modifier.weight(1f)
                )
            }
        }