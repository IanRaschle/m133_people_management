package ch.bbw.personen_verwaltung.controller

import ch.bbw.personen_verwaltung.business.PersonManagement
import ch.bbw.personen_verwaltung.repository.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class UserManagementController(
    @Autowired
    val management: PersonManagement
) {

    @GetMapping("/")
    fun showUsers(model: Model): String {
        model.addAttribute("persons", management.getPersons())
        return "user_management"
    }

    @GetMapping("/createPerson")
    fun createUser(model: Model): String {
        model.addAttribute("person", Person())
        return "edit_persons"
    }

    @PostMapping("/createPerson")
    fun createUser(model: Model, person: Person): String {
        management.createPerson(person)
        model.addAttribute("persons", management.getPersons())
        return "redirect:/"
    }

    @PostMapping("/deletePerson/{id}")
    fun deletePerson(model: Model, @PathVariable("id") id: Int): String {
        management.deletePerson(id)
        model.addAttribute("persons", management.getPersons())
        return "redirect:/"
    }
}
