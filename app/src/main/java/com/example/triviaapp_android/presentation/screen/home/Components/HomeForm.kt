import androidx.compose.runtime.Composable
import com.example.triviaapp_android.presentation.UIStates.home.HomeUIState

@Composable
fun HomeForm(homeUIState: HomeUIState) {
    DividerWithText()
    PlayCardGrid(homeUIState.cardList)
}