package ca.fe.views.character

import ca.fe.blazingblade.HeroModel
import javafx.scene.layout.VBox
import tornadofx.Controller
import tornadofx.Fragment
import tornadofx.label

/**
 * Created by CJ on 6/18/2017.
 */
class StatBoxFragment(private val hero: HeroModel, fx: String, title: String): Fragment() {
    override val root: VBox by fxid(fx)
    init {
        label {
            text = title
        }
    }
}
