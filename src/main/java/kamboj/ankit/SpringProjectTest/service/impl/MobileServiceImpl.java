package kamboj.ankit.SpringProjectTest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import kamboj.ankit.SpringProjectTest.domain.Mobile;
import kamboj.ankit.SpringProjectTest.dto.MobileDto;
import kamboj.ankit.SpringProjectTest.repository.MobileRepository;
import kamboj.ankit.SpringProjectTest.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileServiceImpl implements MobileService {

  @Autowired
  private MobileRepository mobileRepository;

  @Override
  public List<Mobile> getAllMobiles() {
    List<Mobile> mobiles=new ArrayList<>();
    mobileRepository.findAll()
        .forEach(mobiles::add);
    return mobiles;
  }

  @Override
  public Optional<Mobile> getMobile(Long id) {
    return mobileRepository.findById(id);
  }

  @Override
  public Long addMobile(MobileDto mobileDto) {
    Mobile mobile=Mobile.builder()
                    .name(mobileDto.getName())
                    .cost(mobileDto.getCost())
                    .build();
    mobileRepository.save(mobile);
    return mobile.getId();
  }

  @Override
  public Boolean updateMobile(MobileDto mobileDto) {
    Mobile mobile=mobileRepository.findById(mobileDto.getId()).get();
    mobile.setName(mobileDto.getName());
    mobile.setCost(mobileDto.getCost());
    mobileRepository.save(mobile);
    return true;
  }

  @Override
  public Boolean deleteMobile(Long id) {
    mobileRepository.deleteById(id);
    return true;
  }
}
