package it.thomasiommi.mongocktest.service;

import it.thomasiommi.mongocktest.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonService {

    /**
     * Insert a person into the repository
      * @param p Person to insert
     * @return Inserted person
     */
    Person insert(Person p);

    /**
     * Search a person by id
     * @param id UUID of the person to get
     * @return {@code Optional} of the searched person
     */
    Optional<Person> findById(UUID id);

    /**
     * Search all people
     * @return {@code List} of all the people in the repository
     */
    List<Person> findAll();

    /**
     * Updates a person on the repository
     * @param p Person to update
     * @return Updated person
     */
    Person save(Person p);
}
