package jp.co.fullhouse.lespos.lesposapplication.model.entity;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jp.co.fullhouse.lespos.lesposapplication.converter.CompanyStatusConverter;
import jp.co.fullhouse.lespos.lesposapplication.utils.constant.CompanyStatus;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "companies")
@Getter
@Setter
public class Company {
  @Id
  @Column(length = 36, nullable = false, updatable = false, unique = true)
  private String id = UUID.randomUUID().toString();

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
  @Convert(converter = CompanyStatusConverter.class)
  private CompanyStatus status;

  @Column(name = "created_at", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Timestamp createdAt;
}
