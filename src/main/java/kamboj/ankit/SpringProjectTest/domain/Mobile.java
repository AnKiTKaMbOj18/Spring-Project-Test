package kamboj.ankit.SpringProjectTest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="mobiles")
@NoArgsConstructor(access=AccessLevel.PRIVATE)
@AllArgsConstructor(access=AccessLevel.PRIVATE)
@Builder(toBuilder = true)
@ToString
@Data
@EqualsAndHashCode
public class Mobile {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="mobile_id")
  private Long id;

  @Column(name="name")
  private String name;

  @Column(name="cost")
  private Long cost;
}
