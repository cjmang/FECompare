package ca.fe.views.character

import ca.fe.blazingblade.*
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.control.*
import javafx.scene.layout.BorderPane
import javafx.util.Callback
import tornadofx.*

/**
 * Created by CJ on 6/13/2017.
 */
class SummaryView : View() {
    override val root = BorderPane()
    val heroes: ObservableList<Hero> = FXCollections.observableArrayList(Lyn, Rebecca)
    val selectedHero: HeroModel = HeroModel(heroes[0])

    val statView: StatView = StatView(selectedHero)

    init {

        with(root) {
            minHeight = 400.0
            minWidth = 600.0
            left {
                listview(heroes) {
                    selectionModel.selectedItemProperty().addListener(
                            { _, _, newValue -> selectedHero.rebind { hero = newValue } }
                    )
                    cellFormat { hero: Hero? -> text = hero?.name }
                }

                prefHeight = 400.0
                prefWidth = 100.0
            }
            center {
                borderpane {
                    top {
                        anchorpane {
                            hbox {
                                label("Hero")
                                label { bind(selectedHero.name, true) }
                                label("Class")
                                label { bind(selectedHero.archetype, true) }
                            }
                        }
                    }

                    center {
                        this += statView.apply {

                        }
                    }
                }
            }
        }
    }
}
