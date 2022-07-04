package ch.bbw.personen_verwaltung.business

enum class SearchTarget(val text: String) {
    ALL("all"),
    FIRSTNAME("firstname"),
    LASTNAME("lastname"),
    EMAIL("email"),
    BIRTHDATE("birthdate"),
    GENDER("gender")
}
