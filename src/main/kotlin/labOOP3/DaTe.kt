package labOOP3

data class DaTe(val day: Int, val month: Int, val year: Int) {
    override fun toString() = "$day.$month.$year"
}