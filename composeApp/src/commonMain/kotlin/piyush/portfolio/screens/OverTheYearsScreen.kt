package piyush.portfolio.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.alexzhirkevich.compottie.LottieAnimation
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.LottieConstants
import io.github.alexzhirkevich.compottie.Url
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import piyush.portfolio.AndroidGreen
import piyush.portfolio.BgColor
import portfolio_new.composeapp.generated.resources.Res
import portfolio_new.composeapp.generated.resources.oty_image
import portfolio_new.composeapp.generated.resources.oty_image_one
import portfolio_new.composeapp.generated.resources.oty_image_two
import portfolio_new.composeapp.generated.resources.over_the_years


@OptIn(InternalResourceApi::class, ExperimentalResourceApi::class)
@Composable
fun PagerScope.OverTheYearsScreen(pagerState: PagerState) {

    val topAndroidComposition by rememberLottieComposition(
        spec = LottieCompositionSpec.Url(Res.getUri("files/lottie_android_white.json"))
    )

    Box(modifier = Modifier.fillMaxSize().background(color = BgColor)) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.width(230.dp).padding(40.dp).fillMaxHeight()) {
                LottieAnimation(
                    composition = topAndroidComposition,
                    iterations = LottieConstants.IterateForever,
                )
            }
            Column(
                modifier = Modifier.width(700.dp).padding(top = 40.dp)
            ) {
                Text(
                    text = "Over the\nyears,",
                    color = AndroidGreen,
                    fontSize = 80.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(Res.string.over_the_years),
                    color = Color.White,
                    fontSize = 25.sp
                )
            }

            Image(
                painter = painterResource(Res.drawable.oty_image_two),
                contentDescription = "img",
                modifier = Modifier.size(800.dp).padding(end = 40.dp),
                alignment = Alignment.Center
            )

        }
    }

}