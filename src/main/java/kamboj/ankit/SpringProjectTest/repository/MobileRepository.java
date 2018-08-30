package kamboj.ankit.SpringProjectTest.repository;

import kamboj.ankit.SpringProjectTest.domain.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileRepository extends JpaRepository<Mobile,Long> {

}
