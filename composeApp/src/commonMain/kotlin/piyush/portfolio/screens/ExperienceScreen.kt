package piyush.portfolio.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.alexzhirkevich.compottie.LottieAnimation
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.LottieConstants
import io.github.alexzhirkevich.compottie.Url
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.InternalResourceApi
import piyush.portfolio.AndroidGreen
import piyush.portfolio.BgColor
import piyush.portfolio.experienceBgColor
import portfolio_new.composeapp.generated.resources.Res

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
            Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.width(400.dp)) {
                    Text(text = "Live\nProjects", fontSize = 60.sp, color = AndroidGreen)
                    Text(
                        text = "Explore my live projects to see real-world applications of my skills in action, built with passion and precision.",
                        fontSize = 25.sp,
                        color = BgColor
                    )
                    Button(onClick = {

                    }) {
                        Text(text = "See my work")
                    }
                }
                Spacer(modifier = Modifier.width(2.dp).fillMaxHeight().background(Color.Gray))
                Column(modifier = Modifier.width(400.dp)) {
                    Text(text = "Experimental &\nHobby Projects", fontSize = 60.sp, color = AndroidGreen)
                    Text(
                        text = "Discover my experimental and hobby projects where I explore new ideas, tools, and creative solutions beyond the boundaries of work.",
                        fontSize = 25.sp,
                        color = BgColor
                    )
                    Button(onClick = {

                    }) {
                        Text(text = "See my work")
                    }
                }
            }
        }

    }

}