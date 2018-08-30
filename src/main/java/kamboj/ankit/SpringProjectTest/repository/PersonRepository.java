package kamboj.ankit.SpringProjectTest.repository;

import kamboj.ankit.SpringProjectTest.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {

}
