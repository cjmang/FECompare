package ca.fe.views.character

import ca.fe.blazingblade.HeroModel
import javafx.scene.control.Label
import javafx.scene.control.ListView
import javafx.scene.control.SplitPane
import tornadofx.View

/**
 * Created by CJ on 6/13/2017.
 */
class SummaryView : View() {
    override val root: SplitPane by fxml()
    val characterList: ListView<HeroModel> by fxid()
    val nameField: Label by fxid()
    val classField: Label by fxid()
}
