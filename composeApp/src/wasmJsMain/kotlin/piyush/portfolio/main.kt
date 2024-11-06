package piyush.portfolio

import androidx.compose.ui.ExperimentalComposeUiApi
import kotlinx.browser.document
import org.w3c.dom.HTMLCollection
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.KeyboardEvent
import org.w3c.dom.get

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
    /*ComposeViewport(document.body!!) {
        App()
    }*/
    setupArrowKeys()
}

private fun getAllPages(): HTMLCollection {
    return getViewPager().getElementsByClassName("page")
}

private fun getViewPager(): HTMLDivElement {
    return (document.getElementById("viewPager") as? HTMLDivElement)!!
}

fun setupArrowKeys() {
    document.addEventListener("keydown", { event ->
        val keyboardEvent = event as? KeyboardEvent ?: return@addEventListener
        consoleLog("page: $currentPage")
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
    })
}

fun scrollToPage(element: HTMLElement?) {
    scrollIntoViewSmooth(element)
}