package ca.fe.blazingblade

import com.sun.javafx.collections.ObservableMapWrapper
import javafx.beans.property.SimpleMapProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.value.ObservableValue
import javafx.collections.FXCollections
import javafx.collections.ObservableMap
import tornadofx.*

/**
 * Created by CJ on 6/13/2017.
 */

class Hero(name: String, archetype: String, stats:ObservableMap<String, SimpleObjectProperty<Stat>> ){
    val nameProperty = SimpleStringProperty(name)
    val name: String by nameProperty
    val archetypeProperty = SimpleStringProperty(archetype)
    val archetype: String by archetypeProperty
    val statsProperty = SimpleMapProperty<String,SimpleObjectProperty<Stat>>(stats)
    val stats: Map<String,SimpleObjectProperty<Stat>> by statsProperty
    val HP: SimpleObjectProperty<Stat> by stats
    val hp by HP
}

data class HeroModel(var hero: Hero): ViewModel()
{
    val name = bind {hero.nameProperty}
    val archetype = bind {hero.archetypeProperty}
    val stats = bind { hero.statsProperty }
    val statsMap = bind {hero.statsProperty}
    val hp = bind {hero.HP}
}

val Lyn = Hero("Lyn", "Lord", mapOfStats(HP(17,.6)))
val Rebecca = Hero("Rebecca", "Archer", mapOfStats(HP(16,.4)))

fun mapOfStats(vararg stats: Stat): ObservableMapWrapper<String, SimpleObjectProperty<Stat>> =
        ObservableMapWrapper(stats.associateBy( {it.abv}, {SimpleObjectProperty<Stat>(it)}))