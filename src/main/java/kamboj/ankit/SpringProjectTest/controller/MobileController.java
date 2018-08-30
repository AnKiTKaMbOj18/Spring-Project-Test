package kamboj.ankit.SpringProjectTest.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import kamboj.ankit.SpringProjectTest.domain.Mobile;
import kamboj.ankit.SpringProjectTest.dto.MobileDto;
import kamboj.ankit.SpringProjectTest.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4400", maxAge = 3600,
    allowCredentials = "true",
    methods = { RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,
        RequestMethod.OPTIONS})
/*@CrossOrigin(origins = "*", maxAge = 3600)*/
@RestController
@RequestMapping("/mobiles")
public class MobileController {

  private final static String OK = "OK";

  @Autowired
   private MobileService mobileService;

  @GetMapping("/")
  public List<MobileDto> getAllMobiles(){
    return mobileService.getAllMobiles().stream().map(this::buildMobileDto).collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public MobileDto getMobile(@PathVariable Long id){
    Optional<Mobile> mobile= mobileService.getMobile(id);
    return buildMobileDto(mobile.get());
  }

  @PostMapping
  public Long addMobile(@RequestBody MobileDto mobileDto){
    return mobileService.addMobile(mobileDto);
  }

  @PutMapping
  public String updateMobile(@RequestBody MobileDto mobileDto){
    mobileService.updateMobile(mobileDto);
    return OK;
  }

  @DeleteMapping("/{id}")
  public String deleteMobile(@PathVariable Long id){
    mobileService.deleteMobile(id);
    return OK;
  }

  private MobileDto buildMobileDto(Mobile mobile){
    return MobileDto.builder()
        .id(mobile.getId())
        .name(mobile.getName())
        .cost(mobile.getCost())
        .build();
  }
}
