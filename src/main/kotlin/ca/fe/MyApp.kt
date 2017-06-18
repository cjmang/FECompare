package ca.fe

import ca.fe.views.character.SummaryView
import javafx.application.Application
import tornadofx.App

class MyApp : App(SummaryView::class, Styles::class)

fun main(args: Array<String>) {
    Application.launch(MyApp::class.java, *args)
}