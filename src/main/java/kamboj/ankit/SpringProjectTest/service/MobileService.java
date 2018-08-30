package kamboj.ankit.SpringProjectTest.service;

import java.util.List;
import java.util.Optional;
import kamboj.ankit.SpringProjectTest.domain.Mobile;
import kamboj.ankit.SpringProjectTest.dto.MobileDto;

public interface MobileService {

  List<Mobile> getAllMobiles();

  Optional<Mobile> getMobile(Long id);

  Long addMobile(MobileDto mobileDto);

  Boolean updateMobile(MobileDto mobileDto);

  Boolean deleteMobile(Long id);
}
