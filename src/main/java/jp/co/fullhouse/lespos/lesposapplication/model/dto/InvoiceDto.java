
package jp.co.fullhouse.lespos.lesposapplication.model.dto;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceDto {

  private String id;
  private String companyId;
  private Integer status;
  private Integer submitMethod;
  private String clientName;
  private String invoiceRegistrationNumber;
  private Integer invoicedAmount;
  private Integer consumptionTaxRate;
  private Integer taxAmount;
  private Integer excludingTaxAmount;
  private Integer includingTaxAmount;
  private String paymentDueDate;
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
  private CompanyDto company;
  private ImageDto image;

  private String base64Image;
}
