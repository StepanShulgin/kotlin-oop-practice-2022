package labOOP2

enum class ErrList(var erroR:String) {
    ERRRED("Red is in range 0.0..255.0"),
    ERRGREEN("Green color should be initialised in range 0.0..255.0"),
    ERRBLUE("Blue color should be initialised in range 0.0..255.0"),
    ERROPACITY("OPACITY should be initialised in range 0.0..1.0"),
    SideErr("Side size is more then 0"),
    RadErr("Radius should be greater than 0")
}