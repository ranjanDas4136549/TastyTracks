import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedProgressBar(){
    var progress by remember {
        mutableStateOf(0f)
    }
    val animatedProgress = animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(durationMillis = 1000)
    )

    LaunchedEffect(key1 = progress){
        if(progress < 1f){
            progress += 0.1f
        }
    }
    Box(modifier = Modifier.fillMaxSize()){
        Column (
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-0.5).dp)

        ){
            Text(text = "Loading...")
            Spacer(modifier = Modifier.height(16.dp))
            LinearProgressIndicator(
                progress = animatedProgress.value,
                color = Color.Green,
                modifier = Modifier
                    .fillMaxWidth(0.5f)
            )
        }
    }

}