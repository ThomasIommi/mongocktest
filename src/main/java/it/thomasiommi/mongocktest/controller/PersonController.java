package it.thomasiommi.mongocktest.controller;

import it.thomasiommi.mongocktest.exception.ResourceNotFoundException;
import it.thomasiommi.mongocktest.model.Person;
import it.thomasiommi.mongocktest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("people")
public class PersonController {

    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    public Person insert(@RequestBody @NotNull @Valid Person p) {
        return service.insert(p);
    }

    @GetMapping(value = "{id}")
    public Person findById(@PathVariable UUID id) {
        return service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Person with id: %s not found", id)));
    }

    @GetMapping
    public List<Person> findAll() {
        return service.findAll();
    }

    @PatchMapping(value = "{id}")
    public Person save(@PathVariable UUID id, @RequestBody Person p) {
        Person toUpdate = service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Person with id: %s not found", id)));
        Person updated = new Person(toUpdate.getId(), p.getFirstname(), p.getLastname());
        return service.save(updated);
    }

}
