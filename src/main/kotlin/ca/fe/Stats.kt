package ca.fe.blazingblade

/**
 * Created by CJ on 6/17/2017.
 */

sealed class Stat(val name: String, val abv: String, var value: Int, var growth: Double)

data class HP(override var value: Int) : Stat(name="Hit Points", abv="HP")