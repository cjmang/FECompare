package ca.fe.views.character

import ca.fe.blazingblade.HeroModel
import javafx.scene.layout.HBox
import tornadofx.*

/**
 * Created by CJ on 6/18/2017.
 */
class StatView(val selectedHero: HeroModel): View() {
    override val root= HBox()
//    val statBox: VBox by fxid()
//    val baseBox: VBox by fxid()
//    val growthBox: VBox by fxid()
//    val maxBox: VBox by fxid()
    init {
        with(root) {
            vbox {
                label("Stat")
                textfield {bind(selectedHero.hp, true)}
            }
//            vbox {
//                label("Base Value")
//                textfield {bind(selectedHero.hp)}
//            }
        }
//        statBox.add(label{
//            text = "Stat"
//        })
//        statBox.add(textfield {
//            bind(selectedHero.hp, true)
//        })
    }
}
