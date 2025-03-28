package cat.itb.m78.exercices


import androidx.compose.runtime.*
import cat.itb.m78.exercices.api.embassaments.Embassaments
import cat.itb.m78.exercices.examen.Calculator
import cat.itb.m78.exercices.sqldelight.messages.MessagesScreen
import cat.itb.m78.exercices.theme.AppTheme

@Composable
fun App() = AppTheme {
    MessagesScreen()
}
