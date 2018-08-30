package kamboj.ankit.SpringProjectTest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import kamboj.ankit.SpringProjectTest.domain.Mobile;
import kamboj.ankit.SpringProjectTest.domain.Person;
import kamboj.ankit.SpringProjectTest.dto.PersonDto;
import kamboj.ankit.SpringProjectTest.repository.PersonRepository;
import kamboj.ankit.SpringProjectTest.service.MobileService;
import kamboj.ankit.SpringProjectTest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
   private PersonRepository personRepository;

  @Autowired
  private MobileService mobileService;

  @Override
  public List<Person> getAllPersons() {
    List<Person> persons=new ArrayList<>();
    personRepository.findAll()
        .forEach(persons::add);
    return persons;
  }

  @Override
  public Optional<Person> getPerson(Long id) {
    return personRepository.findById(id);
  }

  @Override
  public Long addPerson(PersonDto personDto) {
    Person person = Person.builder()
        .id(personDto.getId())
        .name(personDto.getName())
        .build();
/*    List<Mobile> mobiles = new ArrayList<>();
    for(MobileDto mobileDto: personDto.getMobiles()){
      Optional<Mobile> m=mobileService.getMobile(mobileDto.getId());
      mobiles.add(m.get());
    }
    person.setMobiles(mobiles);
    personRepository.save(person);
    return person.getId();
    }*/
    List<Mobile> mobiles=personDto.getMobiles().stream()
        .map(mobileDto -> mobileService.getMobile(mobileDto.getId()).get()).collect(Collectors.toList());
    person.setMobiles(mobiles);
    personRepository.save(person);
    return person.getId();
  }

  @Override
  public Boolean updatePerson(PersonDto personDto) {
    Person person=personRepository.findById(personDto.getId()).get();
    person.setName(personDto.getName());
    personRepository.save(person);
    return true;
  }

  @Override
  public Boolean deletePerson(Long id) {
    personRepository.deleteById(id);
    return true;
  }
}
