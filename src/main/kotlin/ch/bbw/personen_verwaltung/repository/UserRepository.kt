package ch.bbw.personen_verwaltung.repository

import org.springframework.data.repository.CrudRepository


interface UserRepository : CrudRepository<Person?, Int?>
