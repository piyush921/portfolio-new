package piyush.portfolio.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.alexzhirkevich.compottie.LottieAnimation
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.LottieConstants
import io.github.alexzhirkevich.compottie.Url
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.painterResource
import piyush.portfolio.AndroidGreen
import piyush.portfolio.onHover
import piyush.portfolio.openUrlInNewTab
import portfolio_new.composeapp.generated.resources.Res
import portfolio_new.composeapp.generated.resources.bg_home
import portfolio_new.composeapp.generated.resources.dp
import portfolio_new.composeapp.generated.resources.github
import portfolio_new.composeapp.generated.resources.instagram
import portfolio_new.composeapp.generated.resources.lato_bold
import portfolio_new.composeapp.generated.resources.lato_light
import portfolio_new.composeapp.generated.resources.linkedin
import portfolio_new.composeapp.generated.resources.twitter


@OptIn(InternalResourceApi::class, ExperimentalResourceApi::class)
@Composable
fun PagerScope.HomeScreen(pagerState: PagerState) {
    val coroutineScope = rememberCoroutineScope()

    val nextComposition by rememberLottieComposition(
        spec = LottieCompositionSpec.Url(Res.getUri("files/lottie_arrow_down.json"))
    )

    val topAndroidComposition by rememberLottieComposition(
        spec = LottieCompositionSpec.Url(Res.getUri("files/lottie_top_android.json"))
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(Res.drawable.bg_home),
            contentDescription = "home_bg",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Row() {
            Column(
                modifier = Modifier.weight(0.7f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row() {
                    Text(
                        text = "PIYUSH KUMAR",
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 40.sp,
                        fontFamily = FontFamily(Font(Res.font.lato_bold)),
                        modifier = Modifier.padding(40.dp)
                    )
                    LottieAnimation(
                        composition = topAndroidComposition,
                        iterations = LottieConstants.IterateForever,
                        modifier = Modifier.size(130.dp)
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column() {
                        Text(
                            text = "Android\nDeveloper.",
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 90.sp,
                            fontFamily = FontFamily(Font(Res.font.lato_bold)),
                            modifier = Modifier
                        )
                        Text(
                            text = "Building intuitive mobile experiences\nfrom scratch to production.",
                            color = Color.White,
                            fontSize = 30.sp,
                            fontFamily = FontFamily(Font(Res.font.lato_light)),
                            modifier = Modifier.padding(top = 20.dp)
                        )
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Experienced in wide\nvariety of fields\nincluding OTT, social\nmedia, cabs,\nE-commerce.",
                        color = AndroidGreen,
                        fontSize = 25.sp,
                        fontFamily = FontFamily(Font(Res.font.lato_light)),
                        modifier = Modifier.padding(60.dp)
                    )
                    Text(
                        text = "Proven to be an\nearly adapter, fast\nlearner and build\nsuccessful\nproducts.",
                        color = AndroidGreen,
                        fontSize = 25.sp,
                        fontFamily = FontFamily(Font(Res.font.lato_light)),
                        modifier = Modifier.padding(60.dp)
                    )
                }
            }
            Column(
                modifier = Modifier.weight(0.3f).fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    /*Text(
                        text = "About",
                        color = Color.White,
                        fontFamily = FontFamily(Font(Res.font.lato_light)),
                        modifier = Modifier.padding(20.dp).onFocusChanged { },
                        fontSize = 25.sp
                    )
                    Text(
                        text = "About",
                        color = Color.White,
                        fontFamily = FontFamily(Font(Res.font.lato_light)),
                        modifier = Modifier.padding(20.dp),
                        fontSize = 25.sp
                    )
                    Text(
                        text = "About",
                        color = Color.White,
                        fontFamily = FontFamily(Font(Res.font.lato_light)),
                        modifier = Modifier.padding(20.dp),
                        fontSize = 25.sp
                    )*/
                }
                Column(
                    modifier = Modifier.fillMaxWidth().align(Alignment.End).padding(40.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    CreateBottomIcon(
                        resource = Res.drawable.github,
                        desc = "github",
                        padding = 20.dp,
                        size = 50.dp
                    ) {
                        openUrlInNewTab("https://github.com/piyush921")
                    }
                    CreateBottomIcon(
                        resource = Res.drawable.linkedin,
                        desc = "linkedin",
                        padding = 20.dp,
                        size = 50.dp
                    ) {
                        openUrlInNewTab("https://www.linkedin.com/in/piyush-kumar-220ba0126")
                    }
                    CreateBottomIcon(
                        resource = Res.drawable.twitter,
                        desc = "twitter",
                        padding = 20.dp,
                        size = 50.dp
                    ) {
                        openUrlInNewTab("https://x.com/kumarpiyush921")
                    }
                    CreateBottomIcon(
                        resource = Res.drawable.instagram,
                        desc = "instagram",
                        padding = 20.dp,
                        size = 50.dp
                    ) {
                        openUrlInNewTab("https://www.instagram.com/piyushj_k/")
                    }
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.weight(0.62f))
            Image(
                painter = painterResource(Res.drawable.dp),
                contentDescription = "dp",
                modifier = Modifier.size(500.dp)
            )
            Spacer(modifier = Modifier.weight(0.38f))
        }


    }
}

@Composable
fun CreateBottomIcon(
    resource: DrawableResource,
    desc: String,
    padding: Dp,
    size: Dp,
    onClick: () -> Unit
) {

    var isHovered by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }

    Image(
        painter = painterResource(resource),
        contentDescription = desc,
        colorFilter = ColorFilter.tint(color = if (isHovered) Color.White else AndroidGreen),
        modifier = Modifier
            .padding(padding)
            .size(size)
            .onHover(
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
    )
}