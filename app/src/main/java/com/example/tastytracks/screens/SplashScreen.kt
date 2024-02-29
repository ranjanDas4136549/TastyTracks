import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navigateToMain: MutableState<Boolean>){
    LaunchedEffect(key1 = Unit ){
        delay(1000L)
        navigateToMain.value = true
    }
}