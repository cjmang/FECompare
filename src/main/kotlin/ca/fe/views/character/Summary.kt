package ca.fe.views.character

import ca.fe.blazingblade.*
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.control.Label
import javafx.scene.control.ListCell
import javafx.scene.control.ListView
import javafx.scene.control.SplitPane
import javafx.util.Callback
import tornadofx.View
import tornadofx.bind
import tornadofx.rebind

/**
 * Created by CJ on 6/13/2017.
 */
class SummaryView : View() {
    override val root: SplitPane by fxml()
    val characterList: ListView<Hero> by fxid()
    val nameField: Label by fxid()
    val classField: Label by fxid()
    val heroes: ObservableList<Hero> = FXCollections.observableArrayList(Lyn, Rebecca)
    val selectedHero: HeroModel = HeroModel(heroes[0])

    init {
        characterList.items = heroes
        nameField.bind(selectedHero.name, true)
        classField.bind(selectedHero.archetype, true)
        characterList.selectionModel.selectedItemProperty().addListener({ _, _, newValue -> selectedHero.rebind { hero = newValue } })
        characterList.cellFactory = Callback { _ ->
            object: ListCell<Hero>() {
                override fun updateItem(item: Hero?, empty: Boolean){
                    super.updateItem(item, empty)
                    text = item?.name
                }
            }
        }
    }
}
