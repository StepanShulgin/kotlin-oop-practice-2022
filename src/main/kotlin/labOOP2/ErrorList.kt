package labOOP2

enum class ErrorList(var error: String) {
    ErrorRed("Red is in range 0.0..255.0"),
    ErrorGreen("Green color should be initialised in range 0.0..255.0"),
    ErrorBlue("Blue color should be initialised in range 0.0..255.0"),
    ErrorOpacity("OPACITY should be initialised in range 0.0..1.0"),
    SideErr("Side size is more then 0"),
    RadiusError("Radius should be greater than 0")
}