package jp.co.fullhouse.lespos.lesposapplication.model.dto;

import jp.co.fullhouse.lespos.lesposapplication.utils.constant.CompanyStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDto {
  private String id;

  private String name;

  private String postalCode;

  private String prefecture;

  private String city;

  private String address1;

  private String address2;

  private String tel;

  private CompanyStatus status;

}
