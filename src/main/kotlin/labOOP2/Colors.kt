package labOOP2

import kotlinx.serialization.Serializable


@Serializable
data class Colors(val RED: Double, val GREEN: Double, val BLUE: Double, val opacity: Double) {
    init {
        if (RED < 0.0 || RED > 255.0) {
            throw error(ErrorList.ErrorRed.error)
        }
        if (GREEN < 0.0 || GREEN > 255.0) {
            throw error(ErrorList.ErrorGreen.error)
        }
        if (BLUE < 0.0 || BLUE > 255.0) {
            throw error(ErrorList.ErrorBlue.error)
        }
        if (opacity < 0.0 || opacity > 1.0) {
            throw error(ErrorList.ErrorOpacity.error)
        }
    }


    override fun toString(): String {
        return "ReD color: $RED, GreeN color $BLUE, Blue color $GREEN, Opacity $opacity"
    }
}