package kamboj.ankit.SpringProjectTest.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import kamboj.ankit.SpringProjectTest.domain.Person;
import kamboj.ankit.SpringProjectTest.dto.PersonDto;
import kamboj.ankit.SpringProjectTest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {

  private final static String OK = "OK";

  @Autowired
   private PersonService personService;

  @GetMapping("/")
  public List<Person> getAllPersons(){
    return personService.getAllPersons();
  }

  @GetMapping("/{id}")
  public Optional<Person> getPerson(@PathVariable Long id){
   return personService.getPerson(id);

  }

  @PostMapping
  public Long addPerson(@RequestBody PersonDto personDto){
    return personService.addPerson(personDto);
  }

  @PutMapping
  public String updatePerson(@RequestBody PersonDto personDto){
    personService.updatePerson(personDto);
    return OK;
  }

  @DeleteMapping("/{id}")
  public String deletePerson(@PathVariable Long id){
    personService.deletePerson(id);
    return OK;
  }

/*  private PersonDto buildPersonDto(Person person){
    return PersonDto.builder()
        .id(person.getId())
        .name(person.getName())
        .mobiles(person.getMobiles().stream().map(mobile ->).collect(Collectors.toList()))
        .build();
  }*/
}
