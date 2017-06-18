package ca.fe.blazingblade

import javafx.beans.property.ReadOnlyProperty
import javafx.beans.property.ReadOnlyStringWrapper
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

/**
 * Created by CJ on 6/13/2017.
 */

class Hero(name: String, archetype: String){
    val nameProperty = SimpleStringProperty(name)
    val name by nameProperty
    val archetypeProperty = SimpleStringProperty(archetype)
    val archetype by archetypeProperty
}

data class HeroModel(var hero: Hero): ViewModel()
{
    val name = bind {hero.nameProperty}
    val archetype = bind {hero.archetypeProperty}
}

val Lyn = Hero("Lyn", "Lord")
val Rebecca = Hero("Rebecca", "Archer")