
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.triviaapp_android.R
import com.example.triviaapp_android.presentation.UIStates.home.HomeUIState

@Composable
        fun HomeHeader(
    homeUIState: HomeUIState,
    navController: NavHostController,
    function: () -> Unit
) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(216.dp)
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
                        modifier = Modifier.size(80.dp).clickable {
                            navController.navigate("welcome")
                            function()
                        }
                    )
                }

                Text(
                    text = "Last played",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(bottom = 16.dp)
                )
            }

            Box() {
                Image(
                    painter = painterResource(id = R.drawable.homewavetop),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = (-1).dp),
                    contentScale = ContentScale.Crop
                )

                LastPlayedCard(
                    modifier = Modifier.align(Alignment.Center),
                    homeUIState.lastPlayed,
                    homeUIState.isPlayed
                )

                if(homeUIState.isPlayed){
                    Image(
                        painter = painterResource(id = homeUIState.lastPlayed.mainImage),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .offset(x = 16.dp)
                    )
                }
            }
        }