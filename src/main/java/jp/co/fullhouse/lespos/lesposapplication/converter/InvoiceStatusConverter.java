package jp.co.fullhouse.lespos.lesposapplication.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import jp.co.fullhouse.lespos.lesposapplication.utils.constant.InvoiceStatus;

@Converter
public class InvoiceStatusConverter implements AttributeConverter<InvoiceStatus, Integer> {

  @Override
  public Integer convertToDatabaseColumn(InvoiceStatus status) {
    if (status == null) {
      return null;
    }
    return status.getCode();
  }

  @Override
  public InvoiceStatus convertToEntityAttribute(Integer code) {
    if (code == null) {
      return null;

    }
    return InvoiceStatus.getInvoiceStatusByCode(code);
  }
}