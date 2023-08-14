package jp.co.fullhouse.lespos.lesposapplication.model.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "companies")
@Getter
@Setter
public class Company {
  @Id
  private String id;

  @Column
  private String name;

  @Column
  private String city;

  @Column
  private String prefecture;

  @Column
  private String address1;

  @Column
  private String address2;

  @Column
  private String tel;

  @Column
  private String postalCode;

  @Column
  private int status;

  @Column(name = "created_at", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Timestamp createdAt;
}
