package ch.bbw.personen_verwaltung.controller

import ch.bbw.personen_verwaltung.business.PersonManagement
import ch.bbw.personen_verwaltung.business.Search
import ch.bbw.personen_verwaltung.repository.Person
import lombok.AllArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import javax.validation.Valid

@Controller
class UserManagementController(
    @Autowired
    val management: PersonManagement
): WebMvcConfigurer {

    @GetMapping("/")
    fun showPerson(model: Model): String {
        addAttribute(model)
        return "user_management"
    }

    @GetMapping("/createPerson")
    fun createPerson(model: Model): String {
        model.addAttribute("person", Person())
        model.addAttribute("path", "/Create")
        model.addAttribute("search", Search())
        return "edit_person"
    }

    @PostMapping("/deletePerson/{id}")
    fun deletePerson(model: Model, @PathVariable("id") id: Int): String {
        management.deletePerson(id)
        addAttribute(model)
        return "redirect:/"
    }

    @PostMapping("/editPerson/{id}")
    fun editPerson(model: Model, @PathVariable("id") id: Int): String {
        model.addAttribute("person", management.findPerson(id))
        model.addAttribute("path", "/Edit")
        model.addAttribute("search", Search())
        return "edit_person"
    }

    @PostMapping("/savePerson")
    fun createPerson(model: Model, @Valid person: Person, bindingResult: BindingResult): String {
        if (bindingResult.hasErrors()) {
            model.addAttribute("path", "/Create")
            return "edit_person"
        }
        management.savePerson(person)
        return "redirect:/"
    }

    @PostMapping("/findPerson")
    fun findPerson(model: Model, search: Search): String {
        val findPerson = management.findPerson(search)
        model.addAttribute("persons", findPerson)
        model.addAttribute("path", "/Search")
        model.addAttribute("search", search)
        return "user_management"
    }

    private fun addAttribute(model: Model) {
        model.addAttribute("persons", management.getPersons())
        model.addAttribute("path", "")
        model.addAttribute("search", Search())
    }
}
