import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.triviaapp_android.presentation.UIStates.home.CardState
import com.example.triviaapp_android.presentation.viewmodel.TriviaViewModel

@Composable
fun PlayCardGrid(
    cardList: List<CardState>,
    navigateToDifficultySelection: () -> Unit,
    triviaViewModel: TriviaViewModel
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 600.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 40.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {

        cardList.forEach { card ->
            item {
                PlayCard(
                    title = card.category,
                    totalQuestions = 132,
                    image = card.image,
                    navigateToDifficultySelection = navigateToDifficultySelection,
                    updateCategory = {triviaViewModel.updateCategory(card.categoryId)},
                    resetUIStates = {triviaViewModel.resetUIStates()},
                    updateLastPlayed = {triviaViewModel.updateLastPlayed(card.category)}
                )
            }
        }
    }
}