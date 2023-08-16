package jp.co.fullhouse.lespos.lesposapplication.utils.constant;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jp.co.fullhouse.lespos.lesposapplication.utils.serializer.CompanyStatusSerializer;

@JsonSerialize(using = CompanyStatusSerializer.class)
public enum CompanyStatus {
  ACTIVE(1, "アクティブ"),
  INACTIVE(2, "非アクティブ"),
  SUSPENDED(3, "一時停止");

  private final int code;
  private final String name;

  CompanyStatus(int code, String name) {
    this.code = code;
    this.name = name;
  }

  public int getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public static CompanyStatus getCompanyStatusByCode(int code) {
    for (CompanyStatus status : values()) {
      if (status.getCode() == code) {
        return status;
      }
    }
    throw new IllegalArgumentException("Unknown code: " + code);
  }
}
