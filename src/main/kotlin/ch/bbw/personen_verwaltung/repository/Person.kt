package ch.bbw.personen_verwaltung.repository

import lombok.Data
import org.springframework.format.annotation.DateTimeFormat
import java.sql.Date
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Past
import javax.validation.constraints.Size

@Entity
@Data
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int?,
    //@Size(min = 2, max = 30, message = "Your firstname must be between 2 and 30 characters")
    var firstName: String?,
    //@Size(min = 2, max = 30, message = "Your lastname must be between 2 and 30 characters")
    var lastName: String?,
    //@Email(message = "Email should be valid")
    var email: String?,
    //@Temporal(TemporalType.DATE)
    //@Past(message = "Birthdate should be in the past")
    //@NotNull(message = "Birthdate should not be null")
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    var birthdate: Date?,
    //@NotNull(message = "Gender should not be null")
    var gender: Char?
) {
    constructor() : this(null, null, null, null, null, null)
}
