package labOOP2

import kotlinx.serialization.Serializable



@Serializable
data class Colors(val RED: Double, val GREEN: Double, val BLUE: Double, val OPACIRY: Double) {
    init {
        if (RED < 0.0 || RED > 255.0)
        {
            throw error(ErrList.ERRRED.erroR)
        }
        if (GREEN < 0.0 || GREEN > 255.0)
        {
            throw error(ErrList.ERRGREEN.erroR)
        }
        if (BLUE < 0.0 || BLUE > 255.0)
        {
            throw error(ErrList.ERRBLUE.erroR)
        }
        if (OPACIRY < 0.0 || OPACIRY > 1.0)
        {
            throw error(ErrList.ERROPACITY.erroR)
        }
    }




    override fun toString(): String {
        return "ReD color: $RED, GreeN color $BLUE, Blue color $GREEN, Alpha $OPACIRY"
    }
}