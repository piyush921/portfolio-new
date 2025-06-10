package piyush.portfolio

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.animateLottieCompositionAsState
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import piyush.portfolio.screens.ExperienceScreen
import piyush.portfolio.screens.HomeScreen
import piyush.portfolio.screens.OverTheYearsScreen
import portfolio_new.composeapp.generated.resources.Res

@Composable
@Preview
fun App() {

    val viewModel = remember { AppViewModel() }

    /*MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }

            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                    CreateICon(viewModel)
                }
            }
        }
    }*/

    ShowUi()
}

@Composable
fun ShowUi() {

    val pagerState = rememberPagerState(pageCount = {
        4
    })


    VerticalPager(state = pagerState) { page ->
        when (page) {
            0 -> {
                HomeScreen(pagerState)
            }

            1 -> {
                OverTheYearsScreen(pagerState)
            }

            2 -> {
                ExperienceScreen(pagerState)
            }

            3 -> {
                MessagePage(pagerState)
            }

            4 -> {
                ContactPage(pagerState)
            }
        }
    }
}

@Composable
fun PagerScope.MessagePage(pagerState: PagerState) {
    val coroutineScope = rememberCoroutineScope()

    Row {
        Text(
            text = "Message Page: 3 ",
            modifier = Modifier
        )
        Button(onClick = {
            coroutineScope.launch {
                pagerState.animateScrollToPage(3)
            }
        }, modifier = Modifier) {
            Text("Jump to Page 3")
        }
    }
}

@Composable
fun PagerScope.ContactPage(pagerState: PagerState) {
    val coroutineScope = rememberCoroutineScope()

    Row {
        Text(
            text = "Contacts Page: 4 ",
            modifier = Modifier
        )
        Button(onClick = {
            coroutineScope.launch {
                pagerState.animateScrollToPage(0)
            }
        }, modifier = Modifier) {
            Text("Jump to Page 0")
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun CreateICon(viewModel: AppViewModel) {

    //using compottie-network
    /*viewModel.loadIcon("https://lottie.host/fc0a6552-62b7-4c96-806e-1012e1a9d21c/laicAPPDNl.json")

    val composition by viewModel.composition.collectAsState()
    val progress by animateLottieCompositionAsState(composition)*/

    val composition by rememberLottieComposition {
        LottieCompositionSpec.JsonString(
            Res.readBytes("files/lottie_top_android.json").decodeToString()
        )
    }
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = 3
    )

    Text("Testing1")
    Image(
        painter = rememberLottiePainter(
            composition = composition,
            progress = { progress },
        ),
        contentDescription = "Lottie animation"
    )
}

