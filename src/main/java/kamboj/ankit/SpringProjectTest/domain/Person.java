package kamboj.ankit.SpringProjectTest.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "persons")
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "person_id")
  private Long id;

  @Column(name = "name")
  private String name;

  @OneToMany                                           /*(fetch=FetchType.EAGER,cascade = CascadeType.ALL)*/
  @JoinTable(name = "person_mobile",
      joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "person_id"),
      inverseJoinColumns = @JoinColumn(name = "mobile_id", referencedColumnName = "mobile_id"))
  private List<Mobile> mobiles = new ArrayList<>();
}
