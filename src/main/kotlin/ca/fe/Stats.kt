package ca.fe.blazingblade

import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

/**
 * Created by CJ on 6/17/2017.
 */


sealed class Stat(name: String, abv: String, value: Int, growth: Double) {
    val nameProperty = SimpleStringProperty(name)
    val name: String by nameProperty
    val abvProperty = SimpleStringProperty(abv)
    val abv: String by abvProperty
    val valueProperty = SimpleIntegerProperty(value)
    var value: Int by valueProperty
    val growthProperty = SimpleDoubleProperty(growth)
    var growth: Double by growthProperty
}

class StatModel(val stat: Stat): ViewModel() {
    val name = bind { stat.nameProperty}
    val abv = bind {stat.abvProperty}
    val value = bind {stat.valueProperty}
    val growth = bind { stat.growthProperty}
}

class HP(value: Int, growth: Double) : Stat("Hit Points","HP",value, growth)

class Stats(hp: HP)
{
    val hpProperty = SimpleObjectProperty<HP>(hp)
    val hp:HP by hpProperty
}