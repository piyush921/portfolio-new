package piyush.portfolio.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import org.jetbrains.compose.resources.painterResource
import piyush.portfolio.AndroidGreen
import piyush.portfolio.BgColor
import piyush.portfolio.experienceBgColor
import piyush.portfolio.onHover
import portfolio_new.composeapp.generated.resources.Res
import portfolio_new.composeapp.generated.resources.github
import portfolio_new.composeapp.generated.resources.instagram
import portfolio_new.composeapp.generated.resources.lato_bold
import portfolio_new.composeapp.generated.resources.lato_light
import portfolio_new.composeapp.generated.resources.linkedin
import portfolio_new.composeapp.generated.resources.twitter

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ContactScreen(pagerState: PagerState) {

    val topAndroidComposition by rememberLottieComposition(
        spec = LottieCompositionSpec.Url(Res.getUri("files/lottie_android_white.json"))
    )

    Column(
        modifier = Modifier.background(BgColor).padding(horizontal = 40.dp).fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        LottieAnimation(
            composition = topAndroidComposition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier.size(130.dp)
        )

        Row(
            modifier = Modifier.padding(horizontal = 100.dp).fillMaxWidth()
        ) {
            Column(modifier = Modifier.weight(0.5f)) {
                Text(
                    text = "Get in Touch",
                    color = Color.White,
                    fontSize = 25.sp,
                    fontFamily = FontFamily(Font(Res.font.lato_bold)),
                    modifier = Modifier
                        .padding(20.dp)
                )
                CreateContactButton("kumarpiyush921@gmail.com") {

                }
                CreateContactButton("instagram.com") {

                }
            }
            Column(modifier = Modifier.weight(0.5f)) {
                CreateContactButton("Live Projects") {

                }
                CreateContactButton("Experimental") {

                }
                CreateContactButton("My Resume") {

                }
            }
        }
        Spacer(
            modifier = Modifier.height(1.dp).fillMaxWidth().padding(horizontal = 100.dp)
                .background(AndroidGreen)
        )
        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp)) {
            Image(
                painter = painterResource(Res.drawable.github),
                contentDescription = "github",
                modifier = Modifier.padding(50.dp).size(100.dp)
            )
            Image(
                painter = painterResource(Res.drawable.linkedin),
                contentDescription = "linkedin",
                modifier = Modifier.padding(50.dp).size(100.dp)
            )
            Image(
                painter = painterResource(Res.drawable.twitter),
                contentDescription = "twitter",
                modifier = Modifier.padding(50.dp).size(100.dp)
            )
            Image(
                painter = painterResource(Res.drawable.instagram),
                contentDescription = "instagram",
                modifier = Modifier.padding(50.dp).size(100.dp)
            )
        }
    }


}

@Composable
fun CreateContactButton(title: String, onClick: () -> Unit) {
    var isHovered by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }

    Text(
        text = title,
        color = if (isHovered) Color.White else AndroidGreen,
        fontSize = 30.sp,
        fontFamily = FontFamily(Font(Res.font.lato_light)),
        modifier = Modifier.onHover(
            onEnter = {
                isHovered = true
            },
            onExit = {
                isHovered = false
            }
        ).clickable(
            interactionSource = interactionSource,
            indication = null // 👈 disables default hover effect
        ) { onClick() }
            .padding(20.dp)
    )
}