package jp.co.fullhouse.lespos.lesposapplication.utils.constant;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jp.co.fullhouse.lespos.lesposapplication.utils.serializer.InvoiceStatusSerializer;

@JsonSerialize(using = InvoiceStatusSerializer.class)
public enum InvoiceStatus {
  UNDEALED(1, "未データ化"),
  DEALED(2, "データ化済");

  private final int code;
  private final String name;

  InvoiceStatus(int code, String name) {
    this.code = code;
    this.name = name;
  }

  public int getCode() {
    return this.code;
  }

  public String getName() {
    return this.name;
  }

  public static InvoiceStatus getInvoiceStatusByCode(int code) {
    for (InvoiceStatus invoiceStatus : InvoiceStatus.values()) {
      if (invoiceStatus.getCode() == code) {
        return invoiceStatus;
      }
    }
    return null;
  }

}
