package ch.bbw.personen_verwaltung.business

import ch.bbw.personen_verwaltung.business.SearchTarget.*
import ch.bbw.personen_verwaltung.repository.Person
import org.springframework.beans.factory.annotation.Autowired
import ch.bbw.personen_verwaltung.repository.UserRepository
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class PersonManagement(@Autowired private val repository: UserRepository) {
    fun getPersons() =
         repository.findAll().toList().filterNotNull()

    fun savePerson(person: Person) {
        addPerson(person)
    }

    fun deletePerson(id: Int) {
        repository.deleteById(id)
    }

    fun findPerson(id: Int) =
        repository.findById(id)

    fun findPerson(search: Search): List<Person> {
        val text = search.text.lowercase()
        val target = search.target
        val result = mutableListOf<Person>()
        getPersons().forEach { when {
            it.firstName!!.lowercase().contains(text) && (target == FIRSTNAME || target == ALL) ||
            it.lastName!!.lowercase().contains(text) && (target == LASTNAME || target == ALL) ||
            it.email!!.lowercase().contains(text) && (target == EMAIL || target == ALL) ||
            it.birthdate!!.toString().lowercase().contains(text) && (target == BIRTHDATE || target == ALL) ||
            it.gender!!.lowercase().contains(text) && (target == GENDER || target == ALL) -> result.add(it)
        }}
        return result
    }

    private fun addPerson(person: Person) {
        repository.save(person)
    }
}
