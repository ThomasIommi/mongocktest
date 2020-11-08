package it.thomasiommi.mongocktest.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Person {

    @Id
    private final UUID id;

    @NotBlank
    @JsonProperty
    private final String firstname;

    @NotBlank
    @JsonProperty
    private final String lastname;

    @PersistenceConstructor
    public Person(UUID id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @JsonCreator
    public Person(String firstname, String lastname) {
        this(UUID.randomUUID(), firstname, lastname);
    }

    public UUID getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFullaname() {
        return firstname + " " + lastname;
    }
}
