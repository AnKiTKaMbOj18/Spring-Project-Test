package kamboj.ankit.SpringProjectTest.service;

import java.util.List;
import java.util.Optional;
import kamboj.ankit.SpringProjectTest.domain.Person;
import kamboj.ankit.SpringProjectTest.dto.PersonDto;

public interface PersonService {


  List<Person> getAllPersons();

  Optional<Person> getPerson(Long id);

  Long addPerson(PersonDto personDto);

  Boolean updatePerson(PersonDto personDto);

  Boolean deletePerson(Long id);
}
