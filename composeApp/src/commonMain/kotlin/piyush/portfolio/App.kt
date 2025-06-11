package piyush.portfolio

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview
import piyush.portfolio.screens.ExperienceScreen
import piyush.portfolio.screens.HomeScreen
import piyush.portfolio.screens.OverTheYearsScreen

@Composable
@Preview
fun App() {

    val viewModel = remember { AppViewModel() }

    MaterialTheme (
        //typography = FontFamily.AppFont()
    ) {
        ShowUi()
    }
}

@Composable
fun ShowUi(modifier: Modifier = Modifier) {

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
