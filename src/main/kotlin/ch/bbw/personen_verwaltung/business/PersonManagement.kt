package ch.bbw.personen_verwaltung.business

import ch.bbw.personen_verwaltung.repository.Person
import org.springframework.beans.factory.annotation.Autowired
import ch.bbw.personen_verwaltung.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class PersonManagement(@Autowired private val repository: UserRepository) {
    fun getPersons(): List<Person> {
        return repository.findAll().toList().filterNotNull()
    }

    fun createPerson(person: Person) {
        addPerson(person)
    }

    fun updatePerson(person: Person) {
        addPerson(person)
    }

    fun deletePerson(id: Int) {
        repository.deleteById(id)
    }

    private fun addPerson(person: Person) {
        repository.save(person)
    }
}
