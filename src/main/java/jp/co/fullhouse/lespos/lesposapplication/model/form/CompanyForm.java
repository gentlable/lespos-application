package jp.co.fullhouse.lespos.lesposapplication.model.form;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class CompanyForm {
  private String id;
  @NotBlank
  private String name;
  @NotBlank
  private String postalCode;
  @NotBlank
  private String prefecture;
  @NotBlank
  private String city;
  @NotBlank
  private String address1;
  private String address2;
  private String tel;
  private int status;
}
