
package jp.co.fullhouse.lespos.lesposapplication.model.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jp.co.fullhouse.lespos.lesposapplication.utils.constant.InvoiceStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceDto {

  private String id;
  private String companyId;
  @JsonIgnore
  private InvoiceStatus status;
  private Integer submitMethod;
  private String clientName;
  private String invoiceRegistrationNumber;
  private Integer invoicedAmount;
  private Integer consumptionTaxRate;
  private Integer taxAmount;
  private Integer excludingTaxAmount;
  private Integer includingTaxAmount;
  private LocalDate paymentDueDate;
  private Integer paymentMethod;
  private Integer invoiceType;
  private String bankCode;
  private String bankName;
  private String bankNameKana;
  private String branchCode;
  private String branchName;
  private Integer accountType;
  private String accountNumber;
  private String accountHolderName;
  private String imageId;
  private Timestamp createdAt;
  @JsonIgnore
  private CompanyDto company;
  @JsonIgnore
  private ImageDto image;

  private String base64Image;
}
