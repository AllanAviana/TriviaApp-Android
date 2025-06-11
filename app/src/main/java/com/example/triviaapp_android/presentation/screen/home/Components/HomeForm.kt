import androidx.compose.runtime.Composable
import com.example.triviaapp_android.presentation.UIStates.home.HomeUIState
import com.example.triviaapp_android.presentation.viewmodel.TriviaViewModel

@Composable
fun HomeForm(
    homeUIState: HomeUIState,
    navigateToDifficultySelection: () -> Unit,
    triviaViewModel: TriviaViewModel
) {
    DividerWithText()
    PlayCardGrid(homeUIState.cardList, navigateToDifficultySelection, triviaViewModel)
}