package ch.bbw.personen_verwaltung.business

data class Search (
    val text: String,
    val target: SearchTarget
) {
    constructor() : this("", SearchTarget.ALL)
}
