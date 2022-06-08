package labOOP2

import kotlinx.serialization.Serializable


@Serializable
data class Colors(val red: Double, val green: Double, val blue: Double, val opacity: Double) {
    init {
        if (red < 0.0 || red > 255.0) {
            throw error(ErrorList.ErrorRed.error)
        }
        if (green < 0.0 || green > 255.0) {
            throw error(ErrorList.ErrorGreen.error)
        }
        if (blue < 0.0 || blue > 255.0) {
            throw error(ErrorList.ErrorBlue.error)
        }
        if (opacity < 0.0 || opacity > 1.0) {
            throw error(ErrorList.ErrorOpacity.error)
        }
    }


    override fun toString(): String {
        return "ReD color: $red, GreeN color $blue, Blue color $green, Opacity $opacity"
    }
}