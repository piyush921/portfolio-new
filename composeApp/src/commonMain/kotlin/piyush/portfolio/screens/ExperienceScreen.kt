package piyush.portfolio.screens

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.alexzhirkevich.compottie.LottieAnimation
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.LottieConstants
import io.github.alexzhirkevich.compottie.Url
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.InternalResourceApi
import piyush.portfolio.AndroidGreen
import piyush.portfolio.BgColor
import piyush.portfolio.experienceBgColor
import piyush.portfolio.onHover
import portfolio_new.composeapp.generated.resources.Res
import portfolio_new.composeapp.generated.resources.lato_bold
import portfolio_new.composeapp.generated.resources.lato_light

@OptIn(InternalResourceApi::class, ExperimentalResourceApi::class)
@Composable
fun PagerScope.ExperienceScreen(pagerState: PagerState) {

    val topAndroidComposition by rememberLottieComposition(
        spec = LottieCompositionSpec.Url(Res.getUri("files/lottie_top_android.json"))
    )


    Box(modifier = Modifier.fillMaxSize().background(experienceBgColor)) {

        Box(modifier = Modifier.padding(40.dp)) {
            LottieAnimation(
                composition = topAndroidComposition,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier.size(130.dp)
            )
        }

        Card(
            modifier = Modifier.padding(200.dp).fillMaxSize(),
            backgroundColor = Color.White,
            elevation = 0.dp
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.width(400.dp)) {
                    Text(
                        text = "Live Projects", fontSize = 60.sp, color = AndroidGreen,
                        fontFamily = FontFamily(Font(Res.font.lato_bold))
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Explore my live projects to see real-world applications built with passion.",
                        fontSize = 35.sp,
                        color = BgColor,
                        letterSpacing = 5.sp,
                        fontFamily = FontFamily(Font(Res.font.lato_light))
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    CreateButton("See my Work")
                }
                Spacer(modifier = Modifier.width(2.dp).fillMaxHeight().background(AndroidGreen))
                Column(modifier = Modifier.width(450.dp)) {
                    Text(
                        text = "Experimental &\nHobby Projects",
                        fontSize = 60.sp,
                        color = AndroidGreen,
                        fontFamily = FontFamily(Font(Res.font.lato_bold))
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Discover my experimental and hobby projects.",
                        fontSize = 35.sp,
                        color = BgColor,
                        letterSpacing = 5.sp,
                        fontFamily = FontFamily(Font(Res.font.lato_light))
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    CreateButton("See my Experimental")
                }
            }
        }

    }

}

@Composable
fun CreateButton(title: String) {
    var isHovered by remember { mutableStateOf(false) }

    val animationProgress by animateFloatAsState(
        targetValue = if (isHovered) 1f else 0f,
        animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing),
        label = "hoverAnim"
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .border(
                width = if (!isHovered) 2.dp else 0.dp,
                color = AndroidGreen,
                shape = RoundedCornerShape(0.dp)
            )
            .onHover(
                onEnter = { isHovered = true },
                onExit = { isHovered = false }
            )
            .graphicsLayer {
                clip = true
                shape = RoundedCornerShape(0.dp)
            }
            .background(Color.Transparent)
    ) {
        // Background animation layer
        Box(
            modifier = Modifier
                .matchParentSize()
                .graphicsLayer {
                    scaleX = animationProgress
                    transformOrigin = androidx.compose.ui.graphics.TransformOrigin(0f, 0.5f) // left to right
                }
                .background(AndroidGreen) // Green shade
        )

        // Text layer
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = title,
                fontSize = 22.sp,
                color = if (isHovered) Color.White else Color.Black,
                fontFamily = FontFamily(Font(Res.font.lato_bold))
            )
        }
    }
}