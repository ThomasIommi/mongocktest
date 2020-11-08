package it.thomasiommi.mongocktest.repository;

import it.thomasiommi.mongocktest.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface PersonRepository extends MongoRepository<Person, UUID>, PersonRepositoryCustom {
}
