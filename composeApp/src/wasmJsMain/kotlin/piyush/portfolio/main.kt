package piyush.portfolio

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLCollection
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.KeyboardEvent
import org.w3c.dom.get
import piyush.portfolio.screens.LiveProjectsScreen

private const val totalPages = 4
private var currentPage = 0

@OptIn(ExperimentalJsExport::class)
@JsExport
external fun scrollIntoViewSmooth(element: HTMLElement?)

@OptIn(ExperimentalJsExport::class)
@JsExport
external fun consoleLog(message: String?)

@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    ComposeViewport(document.body!!) {

        val currentPath = remember { mutableStateOf(window.location.pathname) }

        LaunchedEffect(Unit) {
            window.onpopstate = {
                currentPath.value = window.location.pathname
            }
        }


        when (currentPath.value) {
            "/projects" -> {
                consoleLog("rendering projects")
                LiveProjectsScreen()
            }
            else -> {
                consoleLog("rendering home page")
                ShowUi(modifier = Modifier)
            }
        }

        //ShowUi(modifier = Modifier)
    }
    //setupArrowKeys()
    //setupContactsHover()
}

fun setupContactsHover() {
    val buttonUrl = mapOf(
        "github" to "https://github.com/piyush921",
        "linkedin" to "https://www.linkedin.com/in/piyush-kumar-220ba0126",
        "twitter" to "https://x.com/kumarpiyush921",
        "stack" to "https://stackoverflow.com/users/7802802/piyush-kumar"
    )

    buttonUrl.forEach { (id, url) ->
        val button = document.getElementById(id) as? HTMLButtonElement
        button?.onclick = {
            openWebPage(url)
        }
    }
}

private fun openWebPage(url: String) {
    window.open(url, "_blank")
}

private fun getAllPages(): HTMLCollection {
    return getViewPager().getElementsByClassName("page")
}

private fun getViewPager(): HTMLDivElement {
    return (document.getElementById("viewPager") as? HTMLDivElement)!!
}

fun setupArrowKeys() {
    document.addEventListener("keydown") { event ->
        val keyboardEvent = event as? KeyboardEvent ?: return@addEventListener
        //consoleLog("page: $currentPage")
        when (keyboardEvent.key) {
            "ArrowUp" -> {
                if (currentPage == 0) {
                    return@addEventListener
                }
                currentPage--
                scrollToPage(getAllPages()[currentPage] as? HTMLDivElement)
            }

            "ArrowDown" -> {
                if (currentPage == totalPages) {
                    return@addEventListener
                }
                currentPage++
                scrollToPage(getAllPages()[currentPage] as? HTMLDivElement)
            }
        }
    }
}

fun scrollToPage(element: HTMLElement?) {
    scrollIntoViewSmooth(element)
}