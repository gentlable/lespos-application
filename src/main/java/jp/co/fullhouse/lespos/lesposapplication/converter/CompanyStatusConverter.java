package jp.co.fullhouse.lespos.lesposapplication.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import jp.co.fullhouse.lespos.lesposapplication.utils.constant.CompanyStatus;

@Converter
public class CompanyStatusConverter implements AttributeConverter<CompanyStatus, Integer> {

  @Override
  public Integer convertToDatabaseColumn(CompanyStatus status) {
    if (status == null) {
      return null;
    }
    return status.getCode();
  }

  @Override
  public CompanyStatus convertToEntityAttribute(Integer code) {
    if (code == null) {
      return null;
    }
    return CompanyStatus.getCompanyStatusByCode(code);
  }
}