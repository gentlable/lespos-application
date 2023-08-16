package jp.co.fullhouse.lespos.lesposapplication.model.form;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceForm {
  @NotBlank
  private String id;
  @NotBlank
  private String company_id;
  @NotBlank
  private String image_id;
  @NotBlank
  private String clientName;
  private String invoiceRegistrationNumber;
  @NotBlank
  private Integer invoicedAmount;
  @NotBlank
  private Integer consumptionTaxRate;
  @NotBlank
  private Integer taxAmount;
  @NotBlank
  private Integer excludingTaxAmount;
  @NotBlank
  private Integer includingTaxAmount;
  @NotBlank
  private LocalDate paymentDueDate;
  @NotBlank
  private Integer paymentMethod;
  @NotBlank
  private Integer invoiceType;
  @NotBlank
  private String bankCode;
  @NotBlank
  private String bankName;
  @NotBlank
  private String bankNameKana;
  @NotBlank
  private String branchCode;
  @NotBlank
  private String branchName;
  @NotBlank
  private Integer accountType;
  @NotBlank
  private String accountNumber;
  @NotBlank
  private String accountHolderName;
  @NotBlank
  private Integer status;
  @NotBlank
  private Integer submitMethod;

}
