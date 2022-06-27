package ch.bbw.personen_verwaltung.repository

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull


@Entity
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int?,
    @NotNull
    @Min(2)
    @Max(30)
    var firstName: String?,
    @NotNull
    @Min(2)
    @Max(30)
    var lastName: String?,
    @NotNull
    @Email
    var email: String?
) {
    constructor() : this(null, null, null, null)
}
